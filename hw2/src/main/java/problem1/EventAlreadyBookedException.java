package problem1;

/**
 * EventAlreadyBookedException is an object which extends the Exception class and will render
 * message if it is threw.
 */
public class EventAlreadyBookedException extends Exception {

  /**
   * Constructs an EventAlreadyBookedException with specified message String.
   *
   * @param s - a message String
   */
  public EventAlreadyBookedException(String s) {
    super(s);
  }
}
