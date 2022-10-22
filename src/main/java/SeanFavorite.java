package main.java;

public class SeanFavorite extends Transaction{
    public SeanFavorite(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }

    @Override
    public void execute() {
        Screen screen = getScreen();
        screen.displayMessage("Sean's favorite food is three cheese bake ");
    }
}
