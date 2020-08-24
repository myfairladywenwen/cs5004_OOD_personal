package invoiceSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CleaningTest {

  Cleaning testCleaning;
  Size size;
  @Before
  public void setUp() throws Exception {
    size = Size.SMALL;
    testCleaning = new Cleaning(
        "address", size, false, 1, 2);
  }

  @Test
  public void calPrice1() {
    assertEquals(80 * 1 * 1.05, testCleaning.calPrice(), 0.001);
  }

  @Test
  public void calPrice2() {
    size = Size.MED;
    testCleaning = new Cleaning("address", size, true, 9, 4);
    assertEquals(80 * 2 * 1.07 * 0.5, testCleaning.calPrice(), 0.001);
  }

  @Test
  public void calPrice3() {
    size = Size.LARGE;
    testCleaning = new Cleaning("address", size, false, 2, 2);
    assertEquals(80 * 4 * 1.05, testCleaning.calPrice(), 0.001);
  }

  @Test
  public void calPrice4() {
    size = Size.LARGE;
    testCleaning = new Cleaning("address", size, true, 2, 2);
    assertEquals(80 * 4 * 1.05 * 0.9, testCleaning.calPrice(), 0.001);
  }

}