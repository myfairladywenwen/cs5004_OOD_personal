package problem2;

/**
 * EmptyLockerException is an object which extends the Exception class and will render * message if
 * it is threw.
 */
public class EmptyLockerException extends Exception {

  /**
   * Constructs an EmptyLockerException with specified message String.
   *
   * @param s - a message String
   */
  public EmptyLockerException(String s) {
    super(s);
  }
}
