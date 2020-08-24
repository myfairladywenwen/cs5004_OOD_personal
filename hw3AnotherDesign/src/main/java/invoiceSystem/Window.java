package invoiceSystem;

public class Window extends Exterior{
  private int numFloors;
  private static final double HIGH_FLOOR_CHARGE = 1.05;

  public Window(String address, Size size, boolean monthly, int preService, int numFloors) throws ExceedMaxFloorException{
    super(address, size, monthly, preService);
    if (numFloors > 3){
      throw new ExceedMaxFloorException("max is 3 floors.");
    }
    this.numFloors = numFloors;
  }

  @Override
  public double calPrice(){
    return super.calPrice() * this.calFLoorCharge();
  }

  private double calFLoorCharge(){
    if (this.numFloors > 1){
      return HIGH_FLOOR_CHARGE;
    }
    return 1;
  }


}
