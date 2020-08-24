package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {

    private int testDollar = 10;
    private int testCent = 20;
    private Amount testAmount;

    @Before
    public void setUp() throws Exception {
        testAmount = new Amount(testDollar, testCent);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setUpInvalid1() {
        Amount testAmountWrong = new Amount(testDollar, -testCent);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setUpInvalid2() {
        Amount testAmountWrong = new Amount(-testDollar, -testCent);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setUpInvalid3() {
        Amount testAmountWrong = new Amount(testDollar, testCent+100);
    }

    @Test
    public void getDollar() {
        assertEquals(testDollar, testAmount.getDollar());
    }

    @Test
    public void getCent() {
        assertEquals(testCent, testAmount.getCent());
    }

    @Test
    public void convertToCent() {
        assertEquals(1020, testAmount.convertToCent());
        assertNotEquals(1000, testAmount.convertToCent());
    }

    @Test
    public void convertToAmount() {
        assertTrue(testAmount.amountEquals(Amount.convertToAmount(1020)));
        assertFalse(testAmount.amountEquals(Amount.convertToAmount(1000)));
    }

    @Test
    public void amountEquals(){
        Amount testAmount2 = new Amount(10, 20);
        assertTrue(testAmount.amountEquals(testAmount2));
        Amount testAmount3 = new Amount(10, 10);
        assertFalse(testAmount.amountEquals(testAmount3));
        Amount testAmount4 = new Amount(20, 20);
        assertFalse(testAmount.amountEquals(testAmount4));
    }
}