package problem1;

import java.util.EmptyStackException;

/**
 * Mutable Stack ADT. This Stack contains only Integers. A Stack is a LIFO ("last-in, first-out")
 * data structure.
 */
public interface IStack {

  /**
   * Adds an Integer to the Stack.
   *
   * @param item An Integer to push onto the Stack.
   */
  void push(Integer item);

  /**
   * Returns and removes the most recently-added item.
   *
   * @return The most recently-added item.
   * @throws EmptyStackException Throws an EmptyStackException if the method is called on an empty
   *                             Stack. Note: EmptyStackException is a built-in Java exception.
   */
  Integer pop() throws EmptyStackException;

  /**
   * Returns the most recently-added item.
   *
   * @return The most recently-added item.
   * @throws EmptyStackException Throws an EmptyStackException if the method is called on an empty
   *                             Stack. Note: EmptyStackException is a built-in Java exception.
   */
  Integer top() throws EmptyStackException;

  /**
   * Tests if this Stack is empty.
   *
   * @return true if and only if the Stack contains no items. Otherwise return false.
   */
  boolean isEmpty();

}
