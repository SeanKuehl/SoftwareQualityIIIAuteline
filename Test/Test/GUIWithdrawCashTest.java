package Test;

import junit.framework.TestCase;
import main.java.GUIForms.WithdrawCash;

public class GUIWithdrawCashTest extends TestCase {

    public void WithdrawTwentyFromMainAccount(){
        WithdrawCash wc = new WithdrawCash();
        boolean expected = true;
        boolean actual = wc.WithdrawAmount(20.0, 12345);
        assertEquals(expected, actual);
    }


    public void WithdrawTwoHundredFromMainAccount(){
        WithdrawCash wc = new WithdrawCash();
        boolean expected = true;
        boolean actual = wc.WithdrawAmount(200.0, 12345);
        assertEquals(expected, actual);
    }


}
