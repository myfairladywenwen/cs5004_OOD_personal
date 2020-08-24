package problem1;

/**
 * CleaningService is an class representing CleaningService with specified address, size, monthly,
 * preService, and numOfPets
 */
public class CleaningService extends InteriorService {

  /**
   * Constructor for CleaningService
   *
   * @param address    - address of property, represented by a String
   * @param size       - size of property, represented by an Enum constant
   * @param monthly    - a boolean variable to represent whether the service is monthly carried
   * @param preService - an int variable of the number of pre-service of the property
   * @param numOfPets  - an int variable of the number of pets of the property
   */
  public CleaningService(String address, Size size, boolean monthly,
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
    this.charge = super.calculatePrice();
    tenthDiscount();
    monthlyDiscount();
    return this.charge;
  }

}
