package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaintingServiceTest {
  PaintingService testPaintingService;
  Size size;

  @Before
  public void setUp() throws Exception {
    size = Size.SMALL;
    testPaintingService = new PaintingService(
        "address", size, false,1,1);
  }

  @Test
  public void calculatePrice1() {
    assertEquals(80 * 16 * 1.05, testPaintingService.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice2() {
    size = Size.LARGE;
    PaintingService testPaintingService2 = new PaintingService(
        "address", size, true, 9, 3);
    assertEquals(80 * 24 * 1.07 * 0.5, testPaintingService2.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice3() {
    size = Size.LARGE;
    PaintingService testPaintingService3 = new PaintingService(
        "address", size, true, 9, 3);
    assertEquals(80 * 24 * 1.07 * 0.5, testPaintingService3.calculatePrice(), 0.001);
  }
}