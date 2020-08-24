package invoiceSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElectricTest {
  Electric testES;
  Size size;
  @Before
  public void setUp() throws Exception {
    size = Size.SMALL;
    testES = new Electric("address", size, true,9,1,false);
  }

  @Test
  public void calPrice() {
    assertEquals((200 * 1 + 50), testES.calPrice(), 0.001);
  }

  @Test
  public void calPrice2()throws ExceedMaxLicEmployException {
    size = Size.SMALL;
    Electric testES2 = new Electric("address", size, true, 9, 1, true);
    assertEquals((200 * 2 + 50), testES2.calPrice(), 0.001);
  }

  @Test
  public void calculatePrice4()throws ExceedMaxLicEmployException {
    size = Size.LARGE;
    Electric testES2 = new Electric("address", size, true, 9, 2, true);
    assertEquals((200 * 3 + 50), testES2.calPrice(), 0.001);
  }
  @Test
  public void calculatePrice5()throws ExceedMaxLicEmployException {
    size = Size.LARGE;
    Electric testES2 = new Electric("address", size, true, 9, 3, true);
    assertEquals((200 * 3 + 50), testES2.calPrice(), 0.001);
  }

  @Test
  public void calculatePrice6()throws ExceedMaxLicEmployException {
    size = Size.LARGE;
    Electric testES2 = new Electric("address", size, true, 9, 2, false);
    assertEquals((200 * 2 + 50), testES2.calPrice(), 0.001);
  }

  @Test
  public void calculatePrice7()throws ExceedMaxLicEmployException {
    size = Size.LARGE;
    Electric testES2 = new Electric("address", size, true, 9, 0, false);
    assertEquals((200 * 1 + 50), testES2.calPrice(), 0.001);
  }

}