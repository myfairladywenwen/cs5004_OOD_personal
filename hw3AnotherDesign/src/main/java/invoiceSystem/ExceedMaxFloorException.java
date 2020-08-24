package invoiceSystem;

public class ExceedMaxFloorException extends Exception{

  public ExceedMaxFloorException(String message) {
    super(message);
  }
}
