package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WindowCleaningTest {
  WindowCleaning testWindowCleaning;
  Size size;

  @Before
  public void setUp() throws Exception {
    size = Size.SMALL;
    testWindowCleaning = new WindowCleaning(
        "address", size, true, 9, 3);
  }

  @Test (expected = ExceedMaxFloorException.class)
  public void constructorInvalid () throws ExceedMaxFloorException{
    size = Size.SMALL;
    WindowCleaning testWindowCleaning2 = new WindowCleaning(
        "address", size, true, 9, 4);
  }

  @Test
  public void calculatePrice() {
    assertEquals(80*1*1.05*0.5, testWindowCleaning.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice2() throws ExceedMaxFloorException{
    size = Size.SMALL;
    WindowCleaning testWindowCleaning3 = new WindowCleaning(
        "address", size, true, 9, 1);
    assertEquals(80*1*0.5, testWindowCleaning3.calculatePrice(), 0.001);
  }

  @Test
  public void testEquals() throws ExceedMaxFloorException {
    size = Size.SMALL;
    WindowCleaning testWindowCleaning3 = new WindowCleaning(
        "address", size, true, 9, 1);
    WindowCleaning testWindowCleaning4 = new WindowCleaning(
        "address", size, true, 9, 1);
    WindowCleaning testWindowCleaning5 = new WindowCleaning(
        "address", size, true, 8, 1);
    assertTrue(testWindowCleaning3.equals(testWindowCleaning3));
    assertTrue(testWindowCleaning3.equals(testWindowCleaning4));
    assertFalse(testWindowCleaning3.equals("test"));
    assertFalse(testWindowCleaning3.equals(testWindowCleaning5));
  }

  @Test
  public void testToString(){
    assertEquals("WindowCleaning{numOfFloors=3, address='address', size=SMALL, "
        + "monthly=true, preServices=9}", testWindowCleaning.toString());
  }

  @Test
  public void testHashCode(){
    assertEquals(-1174056394, testWindowCleaning.hashCode());
  }
}