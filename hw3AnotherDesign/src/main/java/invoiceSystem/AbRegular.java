package invoiceSystem;

public class AbRegular extends AbService{
  protected static final int BASE_PRICE = 80;
  protected static final double TENTH_DISCOUNT = 0.5;
  protected static final double MONTHLY_DISCOUNT = 0.9;

  public AbRegular(String address, Size size, boolean monthly, int preService) {
    super(address, size, monthly, preService);
  }


  @Override
  public double calPrice(){
    return this.calTime() * BASE_PRICE * calDiscount();
  }


  protected int calTime(){
    switch (this.size){
      case SMALL:
        return 1;
      case MED:
        return 2;
      default: // default is LARGE
        return 4;
    }
  }

  protected double calDiscount(){
    if (this.isTenth()){
      return TENTH_DISCOUNT;
    }
    if(this.monthly){
      return MONTHLY_DISCOUNT;
    }
    return 1;
  }

  private boolean isTenth(){
    return (this.preService + 1)%10 == 0;
  }
}
