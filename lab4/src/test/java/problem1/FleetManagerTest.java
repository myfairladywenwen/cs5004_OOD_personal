package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FleetManagerTest {
  FleetManager testFleetManager;

  @Before
  public void setUp() throws Exception {
    testFleetManager = new FleetManager();
  }

  @Test
  public void drive() {
    Bus testBus = new Bus("busID", (float)4.00, (float)5.00);
    TripReport result = testFleetManager.drive((float) 8.00, testBus);
    Bus testBus2 = new Bus("busID", (float)4.00, (float)5.00);
    assertEquals(new TripReport(testBus2, (float)4.00, (float)8.00, 2), result);
  }
}