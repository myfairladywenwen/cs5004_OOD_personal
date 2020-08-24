package problem2;

/**
 * LockerOccupiedException is an object which extends the Exception class and will render message if
 * it is threw.
 */
public class LockerOccupiedException extends Exception {

  /**
   * Constructs an LockerOccupiedException with specified message String.
   *
   * @param s - a message String
   */
  public LockerOccupiedException(String s) {
    super(s);
  }
}