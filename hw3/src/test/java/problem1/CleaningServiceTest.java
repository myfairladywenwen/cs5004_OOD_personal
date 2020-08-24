package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CleaningServiceTest {

  CleaningService testCleaningService;
  Size size;

  @Before
  public void setUp() throws Exception {
    size = Size.SMALL;
    testCleaningService = new CleaningService(
        "address", size, false, 1, 2);
  }


  @Test
  public void calculatePrice1() {
    assertEquals(80 * 1 * 1.05, testCleaningService.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice2() {
    size = Size.MED;
    testCleaningService = new CleaningService("address", size, true, 9, 4);
    assertEquals(80 * 2 * 1.07 * 0.5, testCleaningService.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice3() {
    size = Size.LARGE;
    testCleaningService = new CleaningService("address", size, false, 2, 2);
    assertEquals(80 * 4 * 1.05, testCleaningService.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice4() {
    size = Size.LARGE;
    testCleaningService = new CleaningService("address", size, true, 2, 2);
    assertEquals(80 * 4 * 1.05 * 0.9, testCleaningService.calculatePrice(), 0.001);
  }

  @Test
  public void testEquals(){
    size = Size.LARGE;
    CleaningService testCleaningService1 = new CleaningService("address",
        size, true, 2, 2);
    CleaningService testCleaningService2 = new CleaningService("address",
        size, true, 2, 2);
    CleaningService testCleaningService3 = new CleaningService("address",
        size, true, 3, 2);
    assertTrue(testCleaningService1.equals(testCleaningService1));
    assertTrue(testCleaningService1.equals(testCleaningService2));
    assertFalse(testCleaningService1.equals(testCleaningService3));
    assertFalse(testCleaningService1.equals("test"));
  }

  @Test
  public void testHashCode(){
    assertEquals(-1174050877, testCleaningService.hashCode());
  }
}