package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class MonthlyTest {

  Monthly testM;

  @Before
  public void setUp() throws Exception {
    testM = new Monthly(10, LocalDate.of(2019, 1, 10));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalid() throws IllegalArgumentException {
    Monthly testM2 = new Monthly(10, LocalDate.of(2021, 1, 1));
  }

  @Test
  public void setCancelDate() {
    testM.setCancelDate(LocalDate.of(2020, 1, 1));
    assertEquals(LocalDate.of(2020, 1, 1), testM.cancelDate);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setCancelDateInvalid() throws IllegalArgumentException {
    testM.setCancelDate(LocalDate.of(2019, 1, 1));
  }

  @Test
  public void testEquals() {
    Monthly testM2 = new Monthly(10, LocalDate.of(2019, 1, 10));
    assertTrue(testM.equals(testM2));
    testM.setCancelDate(LocalDate.of(2020, 1, 1));
    testM2.setCancelDate(LocalDate.of(2020, 1, 1));
    assertTrue(testM.equals(testM2));
    testM2.setCancelDate(LocalDate.of(2020, 10, 1));
    assertFalse(testM.equals(testM2));
    Monthly testM3 = new Monthly(20, LocalDate.of(2019, 1, 10));
    assertFalse(testM.equals(testM3));
    assertTrue(testM.equals(testM));
    assertFalse(testM.equals("monthly"));
  }


  @Test
  public void testHashCode() {
    Monthly testM2 = new Monthly(10, LocalDate.of(2019, 1, 10));
    assertEquals(testM.hashCode(), testM2.hashCode());
    testM2 = new Monthly(10, LocalDate.of(2019, 10, 10));
    assertNotEquals(testM.hashCode(), testM2.hashCode());
  }

  @Test
  public void testToString() {
    String result = testM.toString();
    assertEquals("Monthly{cancelDate=null, amount=10, creationDate=2019-01-10}", result);
  }
}