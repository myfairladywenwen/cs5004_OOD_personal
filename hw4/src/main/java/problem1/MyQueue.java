package problem1;

import java.util.LinkedList;

/**
 * MyQueue is a queue which implements the interface IQueue and can do things FIFO.
 */
public class MyQueue implements IQueue {

  protected LinkedList<Integer> myList;

  /**
   * Constructs a queue.
   *
   * @param myList - the list to construct the queue.
   */
  public MyQueue(LinkedList<Integer> myList) {
    this.myList = myList;
  }

  /**
   * Add an item to the back
   *
   * @param item The Integer to add to the Queue.
   */
  @Override
  public void enqueue(Integer item) {
    this.myList.addLast(item);
  }

  /**
   * pop the front item, if the queue is empty, throw EmptyQueueException
   *
   * @return the item popped
   * @throws EmptyQueueException - if the queue is empty, throw EmptyQueueException
   */
  @Override
  public Integer dequeue() throws EmptyQueueException {
    if (this.myList.isEmpty()) {
      throw new EmptyQueueException();
    }
    return (Integer) this.myList.removeFirst();
  }

  /**
   * Get the front element, if the queue is empty, throw EmptyQueueException
   *
   * @return Integer which is the front element
   * throws EmptyQueueException-if the queue is empty, throw EmptyQueueException
   */
  @Override
  public Integer front() throws EmptyQueueException {
    if (this.myList.isEmpty()) {
      throw new EmptyQueueException();
    }
    return (Integer) this.myList.peek();
  }

  /**
   * Return the size of the queue.
   *
   * @return Integer representing size
   */
  @Override
  public Integer size() {
    return this.myList.size();
  }
}
