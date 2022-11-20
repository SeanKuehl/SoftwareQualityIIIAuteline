package Test;

import junit.framework.TestCase;
import main.java.GUIForms.Authentication;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GUIAuthenticationTest extends TestCase {

    @Test
    public void TestValidAccount() {

        Authentication a = new Authentication();
        boolean expected = true;
        a.EnterAccountNumber("12345");
        a.EnterPin("54321");
        boolean actual = a.PressSubmit();
        assertEquals(expected, actual);

    }

    @Test
    public void TestInvalidAccount() {

        Authentication a = new Authentication();
        boolean expected = true;
        a.EnterAccountNumber("11111");
        a.EnterPin("11111");
        boolean actual = a.PressSubmit();
        assertEquals(expected, actual);

    }


}
