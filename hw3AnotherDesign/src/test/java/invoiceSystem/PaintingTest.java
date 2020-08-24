package invoiceSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaintingTest {
  Painting testPainting;
  Size size;
  @Before
  public void setUp() throws Exception {
    size = Size.SMALL;
    testPainting = new Painting(
        "address", size, false,1,1);
  }

  @Test
  public void calPrice1() {
    assertEquals(80 * 16 * 1.05, testPainting.calPrice(), 0.001);
  }

  @Test
  public void calPrice2() {
    size = Size.LARGE;
    Painting testPainting2 = new Painting(
        "address", size, true, 9, 3);
    assertEquals(80 * 24 * 1.07 * 0.5, testPainting2.calPrice(), 0.001);
  }

  @Test
  public void calPrice3() {
    size = Size.LARGE;
    Painting testPaintingService3 = new Painting(
        "address", size, true, 9, 3);
    assertEquals(80 * 24 * 1.07 * 0.5, testPaintingService3.calPrice(), 0.001);
  }

  @Test
  public void calPrice4() {
    size = Size.LARGE;
    Painting testPainting4 = new Painting(
        "address", size, true, 19, 0);
    assertEquals(80 * 24 * 1 * 0.5, testPainting4.calPrice(), 0.001);
  }
}