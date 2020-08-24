package problem1;

public class ElementNotInListException extends IllegalArgumentException {

  public ElementNotInListException(String s) {
    super(s);
  }
}
