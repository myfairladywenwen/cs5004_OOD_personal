package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Model.Row;

public class RowTest {
  private Row row1;
  private Row row2;

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testConstructor1() throws IllegalArgumentException{
    row1 = new Row(1);
    assertEquals(1, row1.getRowNo());
    assertFalse(row1.getWheelChairAccess());
    assertEquals(10, row1.getSeatsPerRow());
    assertEquals(10, row1.size());
  }

  @Test
  public void testConstructor2() throws IllegalArgumentException{
    row1 = new Row(1, 20, false);
    assertEquals(1, row1.getRowNo());
    assertFalse(row1.getWheelChairAccess());
    assertEquals(20, row1.getSeatsPerRow());
    assertEquals(20, row1.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidRowNo1() throws IllegalArgumentException{
    row1 = new Row(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidRowNo2() throws IllegalArgumentException{
    row1 = new Row(30);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidSeatsPerRow1() throws IllegalArgumentException{
    row1 = new Row(1, 5,false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidSeatsPerRow2() throws IllegalArgumentException{
    row1 = new Row(1, 30,false);
  }

  @Test
  public void testEquals1() {
    row1 = new Row(1, 10, false);
    row2 = new Row(1, 10, false);
    assertTrue(row1.equals(row1));
    assertTrue(row1.equals(row2));
  }

  @Test
  public void testEquals2() {
    row1 = new Row(1, 10, false);
    row2 = new Row(2, 10, false);
    assertFalse(row1.equals(row2));
  }

  @Test
  public void testEquals3() {
    row1 = new Row(1, 10, false);
    row2 = new Row(1, 20, false);
    assertFalse(row1.equals(row2));
  }

  @Test
  public void testEquals4() {
    row1 = new Row(1, 10, false);
    row2 = new Row(1, 10, true);
    assertFalse(row1.equals(row2));
  }

  @Test
  public void testEquals5() {
    row1 = new Row(1, 10, false);
    assertFalse(row1.equals(123));
    assertFalse(row1.equals(null));
  }

  @Test
  public void testHashCode1() {
    row1 = new Row(1, 10, false);
    row2 = new Row(1, 10, false);
    assertEquals(row1.hashCode(),row2.hashCode());
  }

  @Test
  public void testHashCode2() {
    row1 = new Row(1, 10, false);
    row2 = new Row(1, 10, true);
    assertNotEquals(row1.hashCode(),row2.hashCode());
  }

  @Test
  public void testToString() {
    row1 = new Row(1);
    assertEquals("Row{rowNo=1, wheelChairAccess=false, seatsPerRow=10}", row1.toString());
  }

}