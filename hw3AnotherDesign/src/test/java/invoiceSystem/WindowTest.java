package invoiceSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WindowTest {
  Window testWindowCleaning;
  Size size;
  @Before
  public void setUp() throws Exception {
    size = Size.SMALL;
    testWindowCleaning = new Window(
        "address", size, true, 9, 3);
  }

  @Test (expected = ExceedMaxFloorException.class)
  public void constructorInvalid () throws ExceedMaxFloorException{
    size = Size.SMALL;
    Window testWindowCleaning2 = new Window(
        "address", size, true, 19, 4);
  }

  @Test
  public void calculatePrice() {
    assertEquals(80*1*1.05*0.5, testWindowCleaning.calPrice(), 0.001);
  }

  @Test
  public void calculatePrice2() throws ExceedMaxFloorException{
    size = Size.SMALL;
    Window testWindowCleaning3 = new Window(
        "address", size, true, 9, 1);
    assertEquals(80*1*0.5, testWindowCleaning3.calPrice(), 0.001);
  }

}