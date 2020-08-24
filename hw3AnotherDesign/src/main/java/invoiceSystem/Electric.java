package invoiceSystem;

public class Electric extends AbSpecial {
  private static final int PERMIT_FEE = 50;

  public Electric(String address, Size size, boolean monthly, int preService, int numLicEmplyees,
      boolean isComplex) throws ExceedMaxLicEmployException{
    super(address, size, monthly, preService, numLicEmplyees, isComplex);
    if (numLicEmplyees > 4){
      throw new ExceedMaxLicEmployException("can not have more than 4 licensed employees.");
    }
  }


  @Override
  public double calPrice() {
    return super.calPrice() + PERMIT_FEE;
  }
}
