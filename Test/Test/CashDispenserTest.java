package Test;

import main.java.CashDispenser;
import org.junit.Test;
import org.junit.Assert;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CashDispenserTest {

    //@Test
  //  public void testDisplayMessage() {

       // CashDispenser cashDispenser = mock(CashDispenser.class);
   // doNothing().when(cashDispenser).dispenseCash(anyInt());
       // cashDispenser.dispenseCash(21);

    //verify(cashDispenser, times(1)).dispenseCash(21);
    // }

    @Test
    public void isSufficientCashAvailableTrue() {
        CashDispenser cashDispenser = new CashDispenser();
        boolean expected_result = true;
        boolean actual_result = cashDispenser.isSufficientCashAvailable( 100);
        cashDispenser.dispenseCash(100);
        assertEquals(expected_result, actual_result);
    }

    @Test
    public void isSufficientCashAvailableFalse() {
        CashDispenser cashDispenser = new CashDispenser();
        boolean expected_result = false;
        boolean actual_result = cashDispenser.isSufficientCashAvailable( 1000000);
        assertEquals(expected_result, actual_result);
    }
}