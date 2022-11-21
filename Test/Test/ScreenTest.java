package Test;

import main.java.Screen;
import org.junit.Assert;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;

//import static org.mockito.Mockito.*;


public class ScreenTest extends TestCase {


   // public void testDisplayMessage() {

      //  Screen screen = mock(Screen.class);
        //doNothing().when(screen).displayMessage(anyString());
      //  screen.displayMessage("\n[?] Please enter your account number: ");

       // verify(screen, times(1)).displayMessage("\n[?] Please enter your account number: ");
   // }



    public void testGetMessage() {
        Screen screen = new Screen();
        String expected_message = "20.21 CAD has been debited from the account";
        screen.displayMessage(expected_message);
        screen.displayMessageLine(expected_message);
        String actual_message = screen.getMessage(expected_message);
        assertEquals(expected_message, actual_message);
    }

    public void testGetDollarAmount() {
        Screen screen = new Screen();
        double expected_amount = 20.21;
        screen.displayDollarAmount(expected_amount);
        String actual_amount = screen.getDollarAmount(expected_amount);
        assertEquals("$"+ expected_amount, actual_amount);
    }
}