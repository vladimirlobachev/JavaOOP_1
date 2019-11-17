import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import space.harbour.bank.Department;

public class ATMTest {

    Department depart;

    @Before
    public void setUp() {
        depart = new Department();
    }

    @Test
    public void clonningATMsTest() {
        assertTrue(depart.newATMs(4));
    }


    @Test
    public void clonningATMsTestTwo() {
        assertFalse(depart.newATMs(0));   
    }

    @Test
    public void withdrawingFromOneClonedATM() {
        depart.newATMs(4);
        int cash = depart.getATM(0).cashLeft();
        depart.getATM(0).withdraw(500);
        assertEquals(cash - 500, depart.getATM(0).cashLeft());
    }

}