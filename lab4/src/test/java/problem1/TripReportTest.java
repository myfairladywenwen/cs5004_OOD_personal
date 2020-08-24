package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TripReportTest {

  TripReport testTripReport;
  Bus testBus = new Bus("busID", (float)4.00, (float)5.00);
  @Before
  public void setUp() throws Exception {
    testTripReport = new TripReport(testBus, (float)4.00, (float)8.00, 2);
  }

  @Test
  public void getVehicle() {
    assertEquals(testBus, testTripReport.getVehicle());
  }

  @Test
  public void getSpeedMilePerMin() {
    assertEquals(4.00, testTripReport.getSpeedMilePerMin(), 0.01);
  }

  @Test
  public void getDistanceInMiles() {
    assertEquals(8.00, testTripReport.getDistanceInMiles(), 0.01);
  }

  @Test
  public void getDuration() {
    assertEquals(2, testTripReport.getDuration().intValue());
  }

  @Test
  public void testEquals() {
    TripReport testTripReport2 = new TripReport(testBus, 4f,8f,2);
    assertTrue(testTripReport.equals(testTripReport2));
    TripReport testTripReport3 = new TripReport(testBus, 5f,8f,2);
    assertFalse(testTripReport.equals(testTripReport3));
    assertTrue(testTripReport2.equals(testTripReport2));
    assertFalse(testTripReport2.equals("abc"));
  }

  @Test
  public void testHashCode() {
    TripReport testTripReport2 = new TripReport(testBus, 4f,8f,2);
    assertEquals(testTripReport.hashCode(), testTripReport2.hashCode());

    TripReport testTripReport3 = new TripReport(testBus, 5f,8f,2);
    assertNotEquals(testTripReport.hashCode(), testTripReport3.hashCode());
  }
}