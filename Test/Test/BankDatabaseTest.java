package Test;

import main.java.BankDatabase;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankDatabaseTest {


    @Test
    public void authenticateUserTrue() {
        BankDatabase bankdatabase = new BankDatabase();
        boolean actual_result = bankdatabase.authenticateUser(12345,54321);
        boolean expected_result = true;

        assertEquals(expected_result, actual_result);
    }
    public void authenticateUserFalse() {
        BankDatabase bankdatabase = new BankDatabase();
        boolean actual_result = bankdatabase.authenticateUser(12435,54321);
        boolean expected_result = false;

        assertEquals(expected_result, actual_result);
    }

    @Test
    public void getAvailableBalance() {
        BankDatabase bankdatabase = new BankDatabase();
        bankdatabase.credit(12345, 100);
        bankdatabase.debit(12345, 100);
        double actual_result = bankdatabase.getAvailableBalance(12345);
        double expected_result = 900.00;

        assertEquals(expected_result, actual_result, 2);
    }

    @Test
    public void getTotalBalance() {
        BankDatabase bankdatabase = new BankDatabase();
        double actual_result = bankdatabase.getTotalBalance(12345);
        double expected_result = 1200.00;

        assertEquals(expected_result, actual_result, 2);

    }
}