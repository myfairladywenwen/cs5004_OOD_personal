package problem1;

/**
 * PaintingService is an class representing PaintingService with specified address, size, monthly,
 * preService, and numOfPets
 */
public class PaintingService extends InteriorService {

  private static final int HOUR_S_M = 16;
  private static final int HOUR_LARGE = 24;

  /**
   * Constructor for PaintingService
   *
   * @param address    - address of property, represented by a String
   * @param size       - size of property, represented by an Enum constant
   * @param monthly    - a boolean variable to represent whether the service is monthly carried
   * @param preService - an int variable of the number of pre-service of the property
   * @param numOfPets  - an int variable of the number of pets of the property
   */
  public PaintingService(String address, Size size, boolean monthly,
      int preService, int numOfPets) {
    super(address, size, monthly, preService, numOfPets);
  }

  /**
   * Calculates and returns the final charge
   *
   * @return a double of charge
   */
  @Override
  public double calculatePrice() {
    switch (this.size) {
      case SMALL:
      case MED:
        this.charge = BASE_RATE * HOUR_S_M;
        break;
      default:  //default is LARGE (so as test switch can reach 100% coverage)
        this.charge = BASE_RATE * HOUR_LARGE;
        break;
    }
    petsCharge();
    tenthDiscount();
    monthlyDiscount();
    return this.charge;
  }
}
