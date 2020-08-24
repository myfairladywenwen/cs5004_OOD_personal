package problem1;

import static org.junit.Assert.*;

import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

public class IQueueTest {

  IQueue testIQueue;

  @Before
  public void setUp() throws Exception {
    testIQueue = new MyQueue(new LinkedList<Integer>());  //empty
  }

  @Test
  public void enqueue() {
    testIQueue.enqueue(1);  // 1
    assertEquals(1,testIQueue.size().intValue());
  }

  @Test
  public void dequeue() throws EmptyQueueException{
    testIQueue.enqueue(1);  // 1
    testIQueue.enqueue(2);  // 1,2
    testIQueue.dequeue();  //2
    assertEquals(1, testIQueue.size().intValue());
    assertEquals(2, testIQueue.front().intValue());
  }

  @Test (expected = EmptyQueueException.class)
  public void dequeInvalid () throws EmptyQueueException {
    testIQueue = new MyQueue(new LinkedList<Integer>());  // empty
    testIQueue.dequeue();
  }

  @Test
  public void front() throws EmptyQueueException {
    testIQueue.enqueue(1);  // 1
    assertEquals(1, testIQueue.front().intValue());  // 1
  }

  @Test (expected = EmptyQueueException.class)
  public void frontInvalid () throws EmptyQueueException {
    testIQueue.front();
  }

  @Test
  public void size() {
    assertEquals(0, testIQueue.size().intValue());  //empty
    testIQueue.enqueue(1);  // 1
    assertEquals(1, testIQueue.size().intValue());  // 1
  }
}