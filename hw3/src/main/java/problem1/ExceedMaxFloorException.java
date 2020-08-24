package problem1;

/**
 * ExceedMaxFloorExceptioner is an object which extends the Exception class and will render message
 * if it is threw.
 */
public class ExceedMaxFloorException extends Exception {

  /**
   * Constructs an ExceedMaxFloorException with specified message String.
   *
   * @param s - a message String
   */
  public ExceedMaxFloorException(String s) {
    super(s);
  }
}
