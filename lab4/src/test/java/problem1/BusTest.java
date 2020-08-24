package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BusTest {
  Bus testBus;

  @Before
  public void setUp() throws Exception {
    testBus = new Bus("busID", (float)4.00, (float)5.00);
  }

  @Test
  public void testEquals(){
    assertTrue(testBus.equals(testBus));
    assertFalse(testBus.equals("abc"));
    assertTrue(testBus.equals(new Bus("busID", (float)4.00, (float)5.00)));
    assertFalse(testBus.equals(null));
  }

  @Test
  public void testHashCode(){
    Bus testBus2 = new Bus("busID", (float)4.00, (float)5.00);
    assertEquals(testBus.hashCode(), testBus2.hashCode());
  }

}