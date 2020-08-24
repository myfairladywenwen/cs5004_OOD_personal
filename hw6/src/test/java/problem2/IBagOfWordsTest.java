package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IBagOfWordsTest {

  Empty empty;
  Cons cons;

  @Before
  public void setUp() throws Exception {
    empty = Empty.emptyBagOfWords();
    cons = (Cons) empty.add("a");
  }

  @Test
  public void emptyBagOfWords() {
    Empty empty1 = Empty.emptyBagOfWords();
    assertTrue(empty1.isEmpty());
  }

  @Test
  public void isEmpty() {
    Empty empty1 = Empty.emptyBagOfWords();
    assertTrue(empty1.isEmpty());
    assertFalse(cons.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(0, empty.size().intValue());
  }

  @Test
  public void add() {
    Cons cons1 = (Cons) empty.add("aa");
    assertEquals(1, cons1.size().intValue());
    Cons cons2 = (Cons) cons.add("bb");
    assertEquals(2, cons2.size().intValue());
    Cons cons3 = (Cons) cons2.add("a");
    assertEquals("a", cons3.getWord());
  }

  @Test
  public void contains() {
    assertTrue(cons.contains("a"));
    assertFalse(cons.contains("b"));
  }

  @Test
  public void testEquals() {
    Cons cons1 = (Cons) empty.add("aa");
    assertTrue(cons.equals(cons));
    assertFalse(cons.equals(empty));
    assertFalse(cons.equals("other"));
    assertFalse(cons.equals(null));
    Cons cons2 = (Cons) cons1.add("bb"); //cons2: bb aa   cons1:aa empty
    assertFalse(cons2.equals(empty));
    assertFalse(cons2.equals(cons1));
    assertTrue(empty.equals(empty));
    assertTrue(empty.equals(Empty.emptyBagOfWords()));
    assertFalse(empty.equals("this"));
    assertFalse(empty.equals(null));
  }

  @Test
  public void testHashCode() {
    Cons cons1 = (Cons) empty.add("a");
    Cons cons2 = (Cons) empty.add("aa");
    assertEquals(cons.hashCode(), cons1.hashCode());
    assertNotEquals(cons.hashCode(), cons2.hashCode());
    assertEquals(empty.hashCode(), Empty.emptyBagOfWords().hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Cons{word=a, rest=Empty{}}", cons.toString());
    assertEquals("Empty{}", empty.toString());
  }
}