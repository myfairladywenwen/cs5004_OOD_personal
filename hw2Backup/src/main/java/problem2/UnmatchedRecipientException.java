package problem2;

/**
 * UnmatchedRecipientException is an object which extends the Exception class and will render
 * message if it is threw.
 */
public class UnmatchedRecipientException extends Exception {

  /**
   * Constructs an public class UnmatchedRecipientException extends Exception with specified message
   * String.
   *
   * @param s - a message String
   */
  public UnmatchedRecipientException(String s) {
    super(s);
  }
}
