package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

  Person testP;

  @Before
  public void setUp() throws Exception {
    testP = new Person("f", "l");
  }

  @Test
  public void testEquals() {
    assertTrue(testP.equals(new Person("f", "l")));
    assertTrue(testP.equals(testP));
    assertFalse(testP.equals(1));
  }

  @Test
  public void testHashCode() {
    Person testP1 = new Person("f", "l");
    assertEquals(testP.hashCode(), testP1.hashCode());
    Person testP2 = new Person("ff", "l");
    assertNotEquals(testP.hashCode(), testP2.hashCode());
  }
}