package main.java;

public class WithdrawlPathBankDatabase extends BankDatabase{

    @Override
    public int debit(int userAccountNumber, double amount) {
        double amountInBank = getAccount(userAccountNumber).getAvailableBalance();
        if (amount > amountInBank){
            return 0;
        }
        else {
            return 1;
        }
    }
}
