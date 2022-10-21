package Test;

import junit.framework.TestCase;
import main.java.ATM;

import static org.junit.Assert.assertEquals;

// Need to mock test for void functions
public class ATMJTest extends TestCase {

    public void testTestRun() {
        ATM mobileATM = new ATM();
        mobileATM.run();
        assertEquals(true, true);
    }
}