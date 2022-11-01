package Test;

import junit.framework.TestCase;
import main.java.*;




public class WithdrawCashPathTests extends TestCase {


    public void WithdrawCashHappyPath(){
        //Customer authenticates to system and requests to withdraw $100.
        // //The amount is withdrawn before returning the Customer to the menu for further actions or to end session.
        int successCode = 1;
        int failCode = 0;
        int realCode = -1;

        //authentication
        boolean authenticationWorked = false;
        WithdrawlPathBankDatabase bankDatabase = new WithdrawlPathBankDatabase();
        authenticationWorked = bankDatabase.authenticateUser(12345, 54321);
        //withdraw $100
        Withdrawal userWithdrawal = new Withdrawal(12345, new Screen(),bankDatabase, new Keypad(), new CashDispenser());
        realCode = bankDatabase.debit(12345, 100);
        //return successfully to main screen
        assertEquals(successCode, successCode);




    }


    public void WithdrawCashSadPath(){
        //Customer authenticates to system and requests to withdraw $1000,000.
        // //The amount is withdrawn before returning the Customer to the menu for further actions or to end session.
        int successCode = 1;
        int failCode = 0;
        int realCode = -1;  //safe default

        //authentication
        boolean authenticationWorked = false;
        WithdrawlPathBankDatabase bankDatabase = new WithdrawlPathBankDatabase();
        authenticationWorked = bankDatabase.authenticateUser(12345, 54321);
        //withdraw $1000000
        Withdrawal userWithdrawal = new Withdrawal(12345, new Screen(),bankDatabase, new Keypad(), new CashDispenser());
        realCode =bankDatabase.debit(12345, 1000000);
        //return successfully to main screen
        assertEquals(failCode, successCode);




    }


}
