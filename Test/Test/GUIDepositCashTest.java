package Test;

import junit.framework.TestCase;
import main.java.GUIForms.DepositCash;

public class GUIDepositCashTest extends TestCase {

    public void DepositOneHundredIntoMainAccount(){
        DepositCash dc = new DepositCash();
        boolean expected = true;
        dc.EnterDepositAmount("100");
        boolean actual = dc.PressSubmitButton(12345);
        assertEquals(expected, actual);
    }

    public void DepositOneThousandIntoMainAccount(){
        DepositCash dc = new DepositCash();
        boolean expected = true;
        dc.EnterDepositAmount("1000");
        boolean actual = dc.PressSubmitButton(12345);
        assertEquals(expected, actual);
    }

    public void DepositOneThousandTwoHundredThirtyFourIntoMainAccount(){
        DepositCash dc = new DepositCash();
        boolean expected = true;
        dc.EnterDepositAmount("1234");
        boolean actual = dc.PressSubmitButton(12345);
        assertEquals(expected, actual);
    }

}
