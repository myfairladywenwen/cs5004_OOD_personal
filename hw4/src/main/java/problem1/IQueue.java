package problem1;

/**
 * A mutable Queue ADT. This Queue will only contain Integers. A Queue is a FIFO (first-in,
 * first-out) data structure.
 */
public interface IQueue {

  /**
   * Adds an Integer to the Queue.
   *
   * @param item The Integer to add to the Queue.
   */
  void enqueue(Integer item);

  /**
   * Removes and returns the Integer at the front of the Queue if the Queue is not empty.
   *
   * @return The Integer at the front of the Queue, if the Queue is not empty.
   * @throws EmptyQueueException if the Queue is empty.
   */
  Integer dequeue() throws EmptyQueueException;

  /**
   * Returns but does not remove the Integer at the front of the Queue.
   *
   * @return The Integer at the front of the Queue, if the Queue is not empty.
   * @throws EmptyQueueException if the Queue is empty.
   */
  Integer front() throws EmptyQueueException;

  /**
   * Gets the number of items in the Queue.
   *
   * @return The number of items in the Queue.
   */
  Integer size();
}
