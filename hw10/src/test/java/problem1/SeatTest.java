package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Model.Seat;

public class SeatTest {
  private Seat s1;
  private Seat s2;
  private Seat s3;
  private Seat s4;

  @Before
  public void setUp() throws Exception {
    s1 = new Seat("A", "wen");
    s2 = new Seat("B", "wen");
    s3 = new Seat("A", "wen");
    s4 = new Seat("A", "wenwen");
  }

  @Test
  public void testEquals() {
    assertTrue(s1.equals(s1));
  }

  @Test
  public void testEquals2() {
    assertFalse(s1.equals(s2));
  }

  @Test
  public void testEquals3() {
    assertFalse(s1.equals(null));
  }

  @Test
  public void testEquals4() {
    assertFalse(s1.equals(123));
  }

  @Test
  public void testEquals5() {
    assertFalse(s1.equals(s4));
  }

  @Test
  public void testHashCode() {
    assertEquals(s1.hashCode(), s3.hashCode());
  }

  @Test
  public void testHashCode2() {
    assertNotEquals(s1.hashCode(), s2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Seat{seatName='A', reservedFor='wen'}", s1.toString());
  }
}