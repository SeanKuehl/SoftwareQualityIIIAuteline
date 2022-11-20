package Test;

import junit.framework.TestCase;
import main.java.GUIForms.Authentication;
import main.java.GUIForms.ViewMyBalance;
import org.junit.Test;

import javax.swing.text.View;

public class GUIViewMyBalanceTest extends TestCase {

    @Test
    public void TestValidAccount() {

        ViewMyBalance v = new ViewMyBalance();
        boolean expected = true;
        v.SetAccountNumber(12345);
        boolean actual = false;

        if (v.GetTotalBalance() == 1200.0 && v.GetAvailableBalance() == 1000.0){
            actual = true;
        }


        assertEquals(expected, actual);

    }
}
