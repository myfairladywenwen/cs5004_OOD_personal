package invoiceSystem;

public class Interior extends AbRegular{
  protected static final double PET_FEE_LOW = 1.05;
  protected static final double PET_FEE_HIGH = 1.07;
  public int numPets;

  public Interior(String address, Size size, boolean monthly, int preService, int numPets) {
    super(address, size, monthly, preService);
    this.numPets = numPets;
  }

  @Override
  public double calPrice() {
    return super.calPrice() * getPetCharge();
  }

  private double getPetCharge() {
    if (this.numPets == 0) {
      return 1;
    }
    if (this.numPets > 0 && this.numPets <= 2) {
      return PET_FEE_LOW;
    } else {
      return PET_FEE_HIGH;
    }
  }

  }
