package problem2;

/**
 * ExceedLockerSizeException is an object which extends the Exception class and will render message
 * if it is threw.
 */

public class ExceedLockerSizeException extends Exception {

  /**
   * Constructs an ExceedLockerSizeException with specified message String.
   *
   * @param s - a message String
   */
  public ExceedLockerSizeException(String s) {
    super(s);
  }
}
