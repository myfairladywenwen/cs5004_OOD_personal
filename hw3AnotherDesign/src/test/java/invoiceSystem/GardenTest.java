package invoiceSystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GardenTest {
  Garden testGardeningService;
  Size size;

  @Before
  public void setUp() throws Exception {
    size = Size.SMALL;
    testGardeningService = new Garden(
        "address", size, true, 9);
  }

  @Test
  public void calPrice() {
    assertEquals((80 * 1 + 20) * 0.5, testGardeningService.calPrice(), 0.001);
  }
}