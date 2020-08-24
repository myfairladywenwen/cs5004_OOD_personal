package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConsTest {
  Cons c;
  Empty e;


  @Before
  public void setUp() throws Exception {
    e = new Empty();
    c = new Cons(0, e);
  }

  @Test
  public void getFirst() {
    assertEquals(0, c.getFirst().intValue());
  }

  @Test
  public void getRest() {
    assertEquals(e, c.getRest());
  }

  @Test
  public void size() {
    assertEquals(1, c.size().intValue());
  }

  @Test
  public void isEmpty() {
    assertFalse(c.isEmpty());
    assertTrue(e.isEmpty());
  }

  @Test
  public void add() {
    Cons c1 = (Cons)c.add(1);
    assertEquals(2, c1.size().intValue());
  }

  @Test
  public void last() {
    assertEquals(0, c.last().intValue());
  }

  @Test
  public void last1() {
    Cons c1 = new Cons(1, c);
    assertEquals(0, c1.last().intValue());
  }



  @Test
  public void contains() {
    assertTrue(c.contains(0));
    assertFalse(c.contains(1));
  }

  @Test
  public void elementAt() {
    assertEquals(0, c.elementAt(0).intValue());
  }


  @Test(expected = IndexOutOfBoundsException.class)
  public void elementAt1() {
     c.elementAt(5).intValue();
  }

  @Test
  public void elementAt2() {
    Cons c1 = new Cons(1, c);
    assertEquals(0, c1.elementAt(1).intValue());
  }

  @Test
  public void testEquals() {
    assertTrue(c.equals(new Cons(0, e)));
    assertFalse(c.equals(new Cons(1, e)));
    assertFalse(c.equals(e));
    assertFalse(c.equals(null));
    assertFalse(c.equals("abc"));
  }

  @Test
  public void testHashCode() {
    assertNotEquals(new Cons(1, e).hashCode(), e.hashCode());
    assertEquals(c.hashCode(), new Cons(0, e).hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Cons{first=0, rest=Empty{}}", c.toString());
  }
}