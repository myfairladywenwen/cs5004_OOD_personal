package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.EmptyPQ;

public class ConsPQTest {

  ConsPQ consPQ;
  PriorityQueue emptyPQ;

  @Before
  public void setUp() throws Exception {
    emptyPQ = EmptyPQ.createEmpty();
    consPQ = new ConsPQ(0,"a", emptyPQ);
  }

  @Test
  public void getPriority() {
    assertEquals(0, consPQ.getPriority());
  }

  @Test
  public void getValue() {
    assertEquals("a", consPQ.getValue());
  }

  @Test
  public void getRest() {
    assertEquals(emptyPQ, consPQ.getRest());
  }

  @Test
  public void isEmpty() {
    assertTrue(emptyPQ.isEmpty());
    ConsPQ pq1 = (ConsPQ) emptyPQ.add(0,"a");
    assertFalse(pq1.isEmpty());
  }

  @Test
  public void add() {
    ConsPQ pq1 = (ConsPQ) consPQ.add(1,"b");  // 1b 0a
    assertEquals("b", pq1.peek());
    ConsPQ pq2 = (ConsPQ) pq1.add(0, "c"); // 1b 0c 0a
    assertEquals("b", pq1.peek());
  }

  @Test
  public void peek() {
    ConsPQ pq1 = (ConsPQ) emptyPQ.add(0,"a");
    assertEquals("a", pq1.peek());
  }

  @Test
  public void pop() throws PopOnEmptyPQException{
    ConsPQ pq1 = (ConsPQ)emptyPQ.add(0,"a");
    PriorityQueue pq2 = pq1.pop();
    assertTrue(pq2.isEmpty());
  }

  @Test
  public void testEquals(){
    ConsPQ pq1 = (ConsPQ)emptyPQ.add(0, "a");  // pq1: 0a
    ConsPQ pq2 = (ConsPQ)emptyPQ.add(0, "a");  //pq2: 0a
    assertTrue(pq1.equals(pq2));
    ConsPQ pq3 = (ConsPQ)pq1.add(1, "b");  // pq3: 1b, 0a
    assertFalse(pq1.equals(pq3));
    assertTrue(pq1.equals(pq1));
    assertFalse(pq1.equals(null));
    assertFalse(pq1.equals("0a"));
    ConsPQ pq4 = (ConsPQ)pq1.add(1, "c"); //pq4: 1c, 0a
    assertFalse(pq1.equals(pq4));
  }

  @Test
  public void testHashCode(){
    ConsPQ pq1 = (ConsPQ)emptyPQ.add(0, "a");  // pq1: 0a
    ConsPQ pq2 = (ConsPQ)emptyPQ.add(0, "a");  //pq2: 0a
    assertEquals(pq1.hashCode(), pq2.hashCode());  //getRest is null
    ConsPQ pq3 = (ConsPQ)pq1.add(1, "b");  // pq3: 1b, 0a
    assertNotEquals(pq1.hashCode(),pq3.hashCode());
    ConsPQ pq4 = (ConsPQ)pq2.add(1, "b");  // pq4: 1b, 0a
    assertEquals(pq3.hashCode(), pq4.hashCode());  //getRest is not null
    ConsPQ pq5 = (ConsPQ)pq4.add(2, "c");
    assertNotEquals(pq5.hashCode(), pq3.hashCode());
  }

  @Test
  public void testToString(){
    ConsPQ pq1 = (ConsPQ)emptyPQ.add(0, "a");
    assertEquals("Cons{priority=0, value=a, rest=EmptyPQ{}}", pq1.toString());
}
}