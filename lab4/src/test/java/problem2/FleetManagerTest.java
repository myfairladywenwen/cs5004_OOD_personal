package problem2;

import static org.junit.Assert.*;

import java.util.InputMismatchException;
import org.junit.Before;
import org.junit.Test;

public class FleetManagerTest {
  FleetManager testFleetManager;
  @Before
  public void setUp() throws Exception {
    testFleetManager = new FleetManager();
  }

  @Test
  public void testdrive1() {
    Bus testBus = new Bus("bus", 4f,5f);
    TripReport result = testFleetManager.drive(testBus);
    TripReport expected = new TripReport(testBus, 4f, 100f, 25);
    assertEquals(expected, result);
  }

  @Test
  public void testDrive2() {
    Bus testBus = new Bus("bus", 4f,5f);
    TripReport result = testFleetManager.drive(testBus, 100f, 25);
    TripReport expected = new TripReport(testBus, 4f, 100f, 25);
    assertEquals(expected, result);
  }


  @Test
  public void testDrive3() {
    Bus testBus = new Bus("bus", 4f,5f);
    TripReport result = testFleetManager.drive(testBus, 100f,25, 4f);
    TripReport expected = new TripReport(testBus, 4f, 100f, 25);
    assertEquals(expected, result);
  }

  @Test(expected = InputMismatchException.class)
  public void testDrive4() {
    Bus testBus = new Bus("bus", 4f,5f);
    TripReport result = testFleetManager.drive(testBus, 100f,25, 6f);
  }

}