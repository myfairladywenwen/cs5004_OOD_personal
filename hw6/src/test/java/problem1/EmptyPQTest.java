package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem2.Cons;

public class EmptyPQTest {

  EmptyPQ epq;

  @Before
  public void setUp() throws Exception {
    epq = EmptyPQ.createEmpty();
  }

  @Test
  public void createEmpty() {
    EmptyPQ epq2 = EmptyPQ.createEmpty();
    assertTrue(epq2.isEmpty());
  }

  @Test
  public void isEmpty() {
    assertTrue(epq.isEmpty());
  }

  @Test
  public void add() {
    ConsPQ pq = (ConsPQ) epq.add(0,"a");
    assertEquals("a", pq.peek());
  }

  @Test
  public void peek() {
    assertEquals(null, epq.peek());
  }

  @Test(expected = PopOnEmptyPQException.class)
  public void pop() throws PopOnEmptyPQException{
    epq.pop();
  }

  @Test
  public void testEquals() {
    EmptyPQ epq1 = EmptyPQ.createEmpty();
    assertTrue(epq.equals(epq1));
    assertTrue(epq.equals(epq));
    assertFalse(epq.equals("a"));
    assertFalse(epq.equals(null));
  }

  @Test
  public void testHashCode() {
    EmptyPQ epq1 = EmptyPQ.createEmpty();
    assertEquals(epq.hashCode(), epq1.hashCode());
    ConsPQ consPQ = (ConsPQ) epq1.add(0, "a");
    assertNotEquals(epq.hashCode(), consPQ.hashCode());
  }

  @Test
  public void testToString() {
  }
}