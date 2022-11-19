package main.java;

import main.java.GUIForms.Authentication;
import main.java.GUIForms.MainMenu;

import javax.swing.*;
import java.awt.*;

/**
 * SMTI06, 54411850, M Haidar Hanif Task Five: Automated Teller Machine Auteline | Simple ATM
 * simulator with basic features
 */

// ATM.java
// Represents an automated teller machine

public class ATM {

    private boolean GUIMODE = false;
    private boolean userAuthenticated; // whether user is authenticated
    private int currentAccountNumber; // current user's account number
    private Screen screen; // ATM's screen
    private Keypad keypad; // ATM's keypad
    private CashDispenser cashDispenser; // ATM's cash dispenser
    private DepositSlot depositSlot; // ATM's deposit slot
    private BankDatabase bankDatabase; // account information database



    // constants corresponding to main menu options
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    private static Authentication a = new Authentication();

    // no-argument ATM constructor initializes instance variables
    public ATM(boolean guiMode) {

        GUIMODE = guiMode;
        if (GUIMODE){
            userAuthenticated = false; // user is not authenticated to start
            currentAccountNumber = 0; // no current account number to start
            cashDispenser = new CashDispenser(); // create cash dispenser
            depositSlot = new DepositSlot(); // create deposit slot
            bankDatabase = new BankDatabase(); // create acct info database



        }
        else {
            userAuthenticated = false; // user is not authenticated to start
            currentAccountNumber = 0; // no current account number to start
            screen = new Screen(); // create screen
            keypad = new Keypad(); // create keypad
            cashDispenser = new CashDispenser(); // create cash dispenser
            depositSlot = new DepositSlot(); // create deposit slot
            bankDatabase = new BankDatabase(); // create acct info database
        }



    }

    // start ATM
    public void run() {
        if (GUIMODE){



            a.setPreferredSize(new Dimension(600, 600));
            a.setMinimumSize(new Dimension(600,600));
            a.setContentPane(new Authentication().MainPanel);
            a.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            a.setVisible(true);





        }
        else {
            // welcome and authenticate user; perform transactions
            // loop while user is not yet authenticated
            while (!userAuthenticated) {
                screen.displayMessageLine("\n[i] Welcome to Auteline Bank ATM!");
                authenticateUser();
            }
            performTransactions(); // user is now authenticated
            userAuthenticated = false; // reset before next ATM session
            currentAccountNumber = 0; // reset before next ATM session
            screen.displayMessageLine("\n[i] Thank you for banking with Auteline Bank!");
        }


    }



    // attempts to authenticate user against database
    private void authenticateUser() {
        screen.displayMessage("\n[?] Please enter your account number: ");
        int accountNumber = keypad.getInput(); // input account number
        screen.displayMessage("\n[?] Enter your PIN: "); // prompt for PIN
        int pin = keypad.getInput(); // input PIN

        // set userAuthenticated to boolean value returned by database
        userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);
        // check whether authentication succeeded
        if (userAuthenticated) {
            currentAccountNumber = accountNumber;
        } else {
            screen.displayMessageLine("[!] Invalid account number or PIN. Please try again.");
        }
    }

    public static void showMainMenu(){
        a.dispose();
        a.setVisible(false);

        MainMenu mm = new MainMenu();

        mm.setPreferredSize(new Dimension(600,600));
        mm.setMinimumSize(new Dimension(600,600));

        mm.setContentPane(new MainMenu().MainPanel);
        mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mm.setVisible(true);

    }

    // display the main menu and perform transactions
    private void performTransactions() {

        // local variable to store transaction currently being processed
        Transaction currentTransaction;
        boolean userExited = false; // user has not chosen to exit

        // loop while user has not chosen option to exit system
        while (!userExited) {
            // show main menu and get user selection
            int mainMenuSelection = displayMainMenu();
            // decide how to proceed based on user's menu selection
            switch (mainMenuSelection) {
                // user chose to perform one of three transaction types
                case BALANCE_INQUIRY:
                case WITHDRAWAL:
                case DEPOSIT: // initialize as new object of chosen type
                    currentTransaction = createTransaction(mainMenuSelection);
                    currentTransaction.execute(); // execute transaction
                    break;

                case EXIT: // user chose to terminate session
                    screen.displayMessageLine("\n[~] Exiting the system...");
                    userExited = true; // this ATM session should end
                    break;
                default: // user did not enter an integer from 1-4
                    screen.displayMessageLine("\n[!] You did not enter a valid selection! Please try again.");
                    break;
            }
        }
    }

    // display the main menu and return an input selection
    private int displayMainMenu() {
        screen.displayMessageLine("\n[Main menu]");
        screen.displayMessageLine("1 - View my balance");
        screen.displayMessageLine("2 - Withdraw cash");
        screen.displayMessageLine("3 - Deposit funds");
        screen.displayMessageLine("4 - Exit");

        screen.displayMessage("[?] Enter a choice: ");
        return keypad.getInput(); // return user's selection
    }

    // return object of specified Transaction subclass
    private Transaction createTransaction(int type) {
        Transaction temp = null; // temporary Transaction variable
        // determine which type of Transaction to create
        switch (type) {
            case BALANCE_INQUIRY: // create new BalanceInquiry transaction
                temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
                break;
            case WITHDRAWAL: // create new Withdrawal transaction
                temp = new Withdrawal(currentAccountNumber, screen,
                        bankDatabase, keypad, cashDispenser);
                break;
            case DEPOSIT: // create new Deposit transaction
                temp = new Deposit(currentAccountNumber, screen,
                        bankDatabase, keypad, depositSlot);
                break;

        }
        return temp; // return the newly created object
    }

}