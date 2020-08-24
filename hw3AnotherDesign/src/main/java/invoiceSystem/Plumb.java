package invoiceSystem;

public class Plumb extends AbSpecial{
  private static final int PERMIT_FEE = 20;

  public Plumb(String address, Size size, boolean monthly, int preService, int numLicEmplyees,
      boolean isComplex) {
    super(address, size, monthly, preService, numLicEmplyees, isComplex);
  }

  @Override
  public double calPrice() {
    return super.calPrice() + PERMIT_FEE;
  }
}
