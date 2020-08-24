package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GardeningServiceTest {
  GardeningService testGardeningService;
  Size size;

  @Before
  public void setUp() throws Exception {
    size = Size.SMALL;
    testGardeningService = new GardeningService(
        "address", size, true, 9);
  }

  @Test
  public void calculatePrice() {
    assertEquals((80 * 1 + 20) * 0.5, testGardeningService.calculatePrice(), 0.001);
  }

}