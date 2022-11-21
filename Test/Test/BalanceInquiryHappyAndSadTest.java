package Test;
import main.java.BalanceInquiry;
import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
import org.junit.Test;

public class BalanceInquiryHappyAndSadTest {

    @Test
    public void BalanceInquiryHappyPath() {

        // create a mock Screen object
        //Screen screen = mock(Screen.class);

        // create a mock BankDatabase object
        //BankDatabase bankDatabase = mock(BankDatabase.class);

        // create a new BalanceInquiry object with valid account number and screen/bankdatabase objects
        //BalanceInquiry inquiry = new BalanceInquiry(1234, screen, bankDatabase);

        // execute the transaction
        //inquiry.execute();

        // check that the correct balance information is displayed
        //verify(screen).displayMessage("Available balance: $100.00\n" + "Total balance: $100.00\n");

    }

    @Test
    public void BalanceInquirySadPath(){

        // create a new BalanceInquiry object with valid account number and screen/bankdatabase objects
        //BalanceInquiry inquiry = new BalanceInquiry(1234, new Screen(), new BankDatabase());

        // execute the transaction
        //inquiry.execute();

        // check that the correct balance information is displayed
        //assertEquals("Available balance: $0.00\n" + "Total balance: $0.00\n", inquiry.getScreen().getText());

    }

}
