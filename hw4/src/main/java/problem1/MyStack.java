package problem1;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * MyStack is a stack which implements the interface IStack and can do things LIFO.
 */
public class MyStack implements IStack {

  protected LinkedList<Integer> myList;

  /**
   * Constructs a stack.
   *
   * @param myList - the list to construct the stack.
   */
  public MyStack(LinkedList<Integer> myList) {
    this.myList = myList;
  }

  /**
   * Add an item to the top
   *
   * @param item The Integer to add to the stack.
   */
  @Override
  public void push(Integer item) {
    this.myList.add(item);
  }

  /**
   * Remove and return the front item, if the stack is empty, throw EmptyStackException
   *
   * @return the front item
   * @throws EmptyStackException - if the stack is empty, throw EmptyStackException
   */
  @Override
  public Integer pop() throws EmptyStackException {
    if (this.myList.isEmpty()) {
      throw new EmptyStackException();
    }
    return (Integer) this.myList.removeLast();
  }

  /**
   * Return the top item, if empty, throw EmptyStackException
   *
   * @return the front item
   * @throws EmptyStackException if the stack is empty, throw EmptyStackException
   */
  @Override
  public Integer top() throws EmptyStackException {
    if (this.myList.isEmpty()) {
      throw new EmptyStackException();
    }
    return (Integer) this.myList.removeLast();
  }

  /**
   * Check whether the stack is empty, return true if it is empty, false otherwise
   *
   * @return true or false
   */
  @Override
  public boolean isEmpty() {
    return (this.myList.size() == 0);
  }
}

