package Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import main.java.Account;
import org.junit.Test;
import junit.framework.TestCase;
import org.junit.*;
import org.junit.Before;
public class AccountTest extends TestCase {

    private Account myacc = new Account( 12345,54321, 1000, 1200);


    public void testValidatePIN() {
        boolean actual_result = myacc.validatePIN(54321);
        boolean expected_result = true;
        assertEquals(expected_result, actual_result);
    }

    public void testgetAvailableBalance()
    {
        myacc.debit(100);
        double actual_result = myacc.getAvailableBalance();
        double expected_result = 900;
        assertEquals(expected_result, actual_result, 0);
    }

    public void testgetTotalBalance()
    {
        myacc.credit(100);
        double actual_result = myacc.getTotalBalance();
        double expected_result = 1300;
        assertEquals(expected_result, actual_result, 0);
    }
    public void testgetAccountNumber()
    {
        int actual_result = myacc.getAccountNumber();
        int expected_result = 12345;
        assertEquals(expected_result, actual_result);
    }

}