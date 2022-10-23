package main.java;

public class ArunFav extends Transaction
{

    public ArunFav(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase)
    {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }

    @Override
    public void execute() {
        Screen screen = getScreen();
        screen.displayMessage("Arun's favorite food is Mango Chipotle Chicken ");
    }
}
