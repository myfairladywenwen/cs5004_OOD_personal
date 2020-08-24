package problem1;

import static org.junit.Assert.*;

import java.util.EmptyStackException;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

public class IStackTest {
  IStack testIStack;

  @Before
  public void setUp() throws Exception {
    testIStack = new MyStack(new LinkedList<Integer>());  // empty
  }

  @Test
  public void push() {
    testIStack.push(1);  // 1
    assertEquals(1, testIStack.top().intValue());
  }

  @Test
  public void pop() {
    testIStack.push(1);  // 1
    assertEquals(1, testIStack.pop().intValue()); //empty
    assertTrue(testIStack.isEmpty());
  }

  @Test (expected = EmptyStackException.class)
  public void popInvalid(){
    testIStack.pop();  // empty
  }
  @Test (expected = EmptyStackException.class)
  public void topInvalid() {
    testIStack.top();  // empty
  }

  @Test
  public void top(){
    testIStack.push(1);  // 1
    assertEquals(1, testIStack.top().intValue());
  }

  @Test
  public void isEmpty() {
    assertTrue(testIStack.isEmpty());  // empty
    testIStack.push(1);  // 1
    assertFalse(testIStack.isEmpty());
  }
}