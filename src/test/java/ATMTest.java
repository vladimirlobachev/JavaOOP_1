import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ATMTest {

    Main main;

    @Before
    public void setUp() {
        main = new Main();
    }

    @Test
    public void setUpTestFalse() {
        assertFalse(main.setUp(0));
    }

    @Test
    public void setUpTestTrue() {
        assertTrue(main.setUp(4));

    }

    @Test
    public void cashInFourArbitraryContainers() {
        main.setUp(4);
        assertEquals(3000, main.cashLeft());
    }


    @Test
    public void cashLeftAfterWithdrawing500() {
        main.setUp(4);
        main.withdraw(500);
        assertEquals(2500, main.cashLeft());
    }


    @Test
    public void leaveZeroInATM() {
        main.setUp(4);
        main.withdraw(3000);
        assertEquals(0, main.cashLeft());
    }



}