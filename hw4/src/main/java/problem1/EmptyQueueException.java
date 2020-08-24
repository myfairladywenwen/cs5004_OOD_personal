package problem1;

/**
 * Exception to throw if client code attempts to access items in an empty Queue.
 */
public class EmptyQueueException extends Exception {

  /**
   * Constructs a new exception with {@code null} as its detail message. The cause is not
   * initialized, and may subsequently be initialized by a call to {@link #initCause}.
   */
  public EmptyQueueException() {
    super("Queue is empty!");
  }
}
