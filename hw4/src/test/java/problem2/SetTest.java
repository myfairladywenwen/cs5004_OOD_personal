package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetTest {

  Set testSet1;
  Set testSet2;

  @Before
  public void setUp() throws Exception {
    testSet1 = new Set();
  }

  @Test
  public void testEmptySet() {
    Set myEmptySet = testSet1.emptySet();
    assertTrue(myEmptySet.size() == 0);
  }

  @Test
  public void testAdd() {
    testSet1 = testSet1.add(1);
    assertTrue(testSet1.size() == 1);
    testSet1 = testSet1.add(2);
    testSet1 = testSet1.add(3);
    testSet1 = testSet1.add(4);
    assertTrue(testSet1.size() == 4);
    testSet1 = testSet1.add(4);
    assertTrue(testSet1.size() == 4);
  }

  @Test
  public void testRemove() {
    testSet1 = testSet1.add(1);
    testSet1 = testSet1.add(2);
    testSet1 = testSet1.add(3);
    testSet1 = testSet1.remove(5);
    assertTrue(testSet1.size() == 3);  //1,2,3
    testSet1 = testSet1.remove(3);  // 1,2
    assertFalse(testSet1.contains(3));
    assertTrue(testSet1.size() == 2);
  }

  @Test
  public void testEquals() {
    testSet1 = testSet1.add(1);
    testSet1 = testSet1.add(2);
    testSet1 = testSet1.add(3);  // testSet1: 1,2,3
    testSet2 = new Set();
    testSet2 = testSet2.add(4);
    testSet2 = testSet2.add(2);
    testSet2 = testSet2.add(1);  // testSet2: 4,2,1
    assertFalse(testSet1.equals(testSet2));
    testSet2 = testSet2.remove(4);  // testSet2: 2, 1
    testSet2 = testSet2.add(3);  // testSet2: 3, 2, 1
    assertTrue(testSet1.equals(testSet2));
    assertFalse(testSet1.equals("1"));
    assertTrue(testSet1.equals(testSet1));
    Set testSet3 = new Set();
    testSet3.add(1);
    assertFalse(testSet1.equals(testSet3));
    testSet3.add(2);
    testSet3.add(3);
    testSet3.add(4);
    testSet3.add(5);
    testSet3.add(6);  //testSet3 capacity 6
    assertFalse(testSet1.equals(testSet3));
  }

  @Test
  public void testHashcode() {
    testSet1 = testSet1.add(1);
    assertEquals(1055, testSet1.hashCode());
    testSet2 = new Set();
    testSet2 = testSet2.add(1);
    assertEquals(testSet1.hashCode(), testSet2.hashCode());
    testSet2 = testSet2.add(2);
    assertNotEquals(testSet1.hashCode(), testSet2.hashCode());
  }

  @Test
  public void testToString() {
    testSet1 = testSet1.add(1);
    testSet1 = testSet1.add(2);
    testSet1 = testSet1.add(3);
    assertEquals("Set{myArray= [1, 2, 3], capacity=3, size=3}", testSet1.toString());
  }
}