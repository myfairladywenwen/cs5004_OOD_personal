package invoiceSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlumbTest {
  Size size;
  Plumb testPL;

  @Before
  public void setUp() throws Exception {
    size = Size.SMALL;
    testPL = new Plumb("address", size, true,9,1,false);
  }

  @Test
  public void calPrice() {
    assertEquals((200 * 1 + 20), testPL.calPrice(), 0.001);
  }

  @Test
  public void calPrice2()throws ExceedMaxLicEmployException {
    size = Size.SMALL;
    Plumb testPL2 = new Plumb("address", size, true, 9, 1, true);
    assertEquals((200 * 2 + 20), testPL2.calPrice(), 0.001);
  }
}