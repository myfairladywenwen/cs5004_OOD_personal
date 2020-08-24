package problem1;

/**
 * GardeningService is an object which extends ExteriorService
 */
public class GardeningService extends ExteriorService {

  private static final int WASTE_FEE = 20;

  /**
   * Constructor for GardenCleaningService with specified address, size, monthly, preService
   *
   * @param address    - address of property, represented by a String
   * @param size       - size of property, represented by an Enum constant
   * @param monthly    - a boolean to represent whether the service is monthly carried
   * @param preService - an int value to represent the number of pre-service of the property
   */
  public GardeningService(String address, Size size, boolean monthly, int preService) {
    super(address, size, monthly, preService);
  }

  /**
   * Calculates and returns the final charge
   *
   * @return a double of charge
   */
  @Override
  public double calculatePrice() {
    this.charge = super.calculatePrice();
    this.charge += WASTE_FEE;
    tenthDiscount();
    monthlyDiscount();
    return this.charge;
  }

  //inherit equals and hashcode which have been overridden in AbstractService
  //inherit toString which have been overridden in AbstractService
}
