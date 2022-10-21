package Test;

import main.java.DepositSlot;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepositSlotTest {

    @Test
    public void isEnvelopeReceived() {
        DepositSlot depositslot = new DepositSlot();
        boolean actual_result =  depositslot.isEnvelopeReceived();
        boolean expected_result = true;

        assertEquals(expected_result, actual_result);
    }
}