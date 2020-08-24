package invoiceSystem;

import com.sun.imageio.plugins.tiff.TIFFImageMetadataFormatResources;

public class AbSpecial extends AbService{
  protected int numLicEmplyees;
  protected boolean isComplex;

  protected static final int NON_COMPLEX_MIN_LIC = 1;
  private static final int MIN_S_M_NUM_LIC = 2;
  private static final int MIN_L_NUM_LIC = 3;
  protected static final int BASE_PRICE = 200;


  public AbSpecial(String address, Size size, boolean monthly, int preService, int numLicEmplyees,
      boolean isComplex) {
    super(address, size, monthly, preService);
    this.isComplex = isComplex;
    if (this.isComplex) {
      switch (this.size) {
        case LARGE:
          if (numLicEmplyees < MIN_L_NUM_LIC) {
            this.numLicEmplyees = MIN_L_NUM_LIC;
          } else {
            this.numLicEmplyees = numLicEmplyees;
          }
          break;
        case MED:
        case SMALL:
          if (numLicEmplyees < MIN_S_M_NUM_LIC) {
            this.numLicEmplyees = MIN_S_M_NUM_LIC;
          } else {
            this.numLicEmplyees = numLicEmplyees;
          }
          break;
      }
    }else{
        if (numLicEmplyees < NON_COMPLEX_MIN_LIC) {
          this.numLicEmplyees = NON_COMPLEX_MIN_LIC;
        } else {
          this.numLicEmplyees = numLicEmplyees;
        }
      }
    }

  @Override
  public double calPrice() {
    return BASE_PRICE * this.numLicEmplyees;
  }
}
