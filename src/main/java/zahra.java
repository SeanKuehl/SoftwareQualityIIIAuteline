package main.java;

public class zahra extends Transaction
{

    public zahra(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase)
    {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }

    @Override
    public void execute() {
        Screen screen = getScreen();
        screen.displayMessage("Zahra's favorite food is sushi");
    }
}