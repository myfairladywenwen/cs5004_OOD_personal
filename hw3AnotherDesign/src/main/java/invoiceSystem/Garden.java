package invoiceSystem;

public class Garden extends Exterior {
  private static final int GARBAGE_FEE = 20;

  public Garden(String address, Size size, boolean monthly, int preService) {
    super(address, size, monthly, preService);
  }

  @Override
  public double calPrice(){
    //return super.calPrice() + GARBAGE_FEE;
    return (this.calTime() * BASE_PRICE + GARBAGE_FEE) * calDiscount();
  }
}
