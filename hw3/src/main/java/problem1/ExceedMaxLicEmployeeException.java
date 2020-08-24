package problem1;

/**
 * ExceedMaxLicEmployeeException is an object which extends the Exception class and will render
 * message if it is threw.
 */
public class ExceedMaxLicEmployeeException extends Exception {

  /**
   * Constructs an ExceedMaxLicEmployeeException with specified message String.
   *
   * @param s - a message String
   */
  public ExceedMaxLicEmployeeException(String s) {
    super(s);
  }
}
