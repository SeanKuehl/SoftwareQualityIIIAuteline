package main.java.GUIForms;

import main.java.ATM;
import main.java.BankDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawCash extends JFrame{
    private JButton button1;
    private JButton $20Button;
    private JButton $40Button;
    private JButton $60Button;
    private JButton $100Button;
    private JButton $200Button;
    public JPanel MainPanel;


    public WithdrawCash(){
/*
availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());
        // check whether the user has enough money in the account
        if (amount <= availableBalance) {
          // check whether the cash dispenser has enough money
          if (cashDispenser.isSufficientCashAvailable(amount)) {
            // update the account involved to reflect the withdrawal

 */
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //back button
                ATM.showMainMenu();
            }
        });
        $20Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //withdraw 20
                double amount = 20.0;
                double availableBalance = ATM.bankDatabase.getAvailableBalance(ATM.GetAccountNumber());
                if (availableBalance >= amount){
                    ATM.bankDatabase.debit(ATM.GetAccountNumber(), amount);
                    ATM.showMainMenu();
                }
                else {

                }


            }
        });
        $40Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //withdraw 40

                double amount = 40.0;
                double availableBalance = ATM.bankDatabase.getAvailableBalance(ATM.GetAccountNumber());
                if (availableBalance >= amount){
                    ATM.bankDatabase.debit(ATM.GetAccountNumber(), amount);
                    ATM.showMainMenu();
                }
                else {

                }
            }
        });
        $60Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //withdraw 60
                double amount = 60.0;
                double availableBalance = ATM.bankDatabase.getAvailableBalance(ATM.GetAccountNumber());
                if (availableBalance >= amount){
                    ATM.bankDatabase.debit(ATM.GetAccountNumber(), amount);
                    ATM.showMainMenu();
                }
                else {

                }
            }
        });
        $100Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //withdraw 100
                double amount = 100.0;
                double availableBalance = ATM.bankDatabase.getAvailableBalance(ATM.GetAccountNumber());
                if (availableBalance >= amount){
                    ATM.bankDatabase.debit(ATM.GetAccountNumber(), amount);
                    ATM.showMainMenu();
                }
                else {

                }
            }
        });
        $200Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //withdraw 200
                double amount = 200.0;
                double availableBalance = ATM.bankDatabase.getAvailableBalance(ATM.GetAccountNumber());
                if (availableBalance >= amount){
                    ATM.bankDatabase.debit(ATM.GetAccountNumber(), amount);
                    ATM.showMainMenu();
                }
                else {

                }
            }
        });
    }


    public boolean WithdrawAmount(double amount, int account){

        BankDatabase db = new BankDatabase();
        double availableBalance = db.getAvailableBalance(account);
        if (availableBalance >= amount){
            return true;
        }
        else {
            return false;
        }
    }


}
