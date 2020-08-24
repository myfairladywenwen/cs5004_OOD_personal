package problem1;

public class PopOnEmptyPQException extends Exception{

  /**
   * Constructs a new PopOnEmptyPQException with the specified detail message.
   *
   * @param message - the detail message.
   */
  public PopOnEmptyPQException(String message) {
    super(message);
  }
}
