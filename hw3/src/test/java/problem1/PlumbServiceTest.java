package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlumbServiceTest {
  Size size;
  PlumbService testPL;

  @Before
  public void setUp() throws Exception {
    size = Size.SMALL;
    testPL = new PlumbService("address", size, true,9,1,false);
  }

  @Test
  public void calculatePrice() {
    assertEquals((200 * 1 + 20), testPL.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice2()throws ExceedMaxLicEmployeeException {
    size = Size.SMALL;
    PlumbService testPL2 = new PlumbService("address", size, true, 9, 1, true);
    assertEquals((200 * 2 + 20), testPL2.calculatePrice(), 0.001);
  }

}