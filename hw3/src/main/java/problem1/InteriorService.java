package problem1;

import java.util.Objects;

/**
 * InteriorService is an abstract class extends AbstractRegularService and will be extended by
 * CleaningService and PaintingService
 */
public abstract class InteriorService extends AbstractRegularService {

  protected int numOfPets;
  protected static final int HIGH_PET_CHARGE_COUNT = 3;
  protected static final double LOW_PET_CHARGE_RATE = 0.05;
  protected static final double HIGH_PET_CHARGE_RATE = 0.07;

  /**
   * Constructor for InteriorService, won't be initialize here, just for subclasses
   *
   * @param address    - address of property, represented by a String
   * @param size       - size of property, represented by an Enum constant
   * @param monthly    - a boolean variable to represent whether the service is monthly carried
   * @param preService - an int variable of the number of pre-service of the property
   * @param numOfPets  - an int variable of the number of pets
   */
  public InteriorService(String address, Size size, boolean monthly,
      int preService, int numOfPets) {
    super(address, size, monthly, preService);
    this.numOfPets = numOfPets; // default is 0
  }

  /**
   * calculate pets charge
   */
  protected void petsCharge() {
    if (this.numOfPets < HIGH_PET_CHARGE_COUNT) {  // should consider 0
      this.charge *= (1 + LOW_PET_CHARGE_RATE);
    } else {
      this.charge *= (1 + HIGH_PET_CHARGE_RATE);
    }
  }

  /**
   * calculates the price plus pets charge and return it
   *
   * @return a double representing price
   */
  @Override
  public double calculatePrice() {
    super.calculatePrice();
    petsCharge();
    return this.charge;
  }

  /**
   * check whether two object of Interior class has same monthly, preServices, address, size and
   * numOfPets
   *
   * @param o - object to be compared
   * @return true if same, otherwise return false
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    if (this == o) {
      return true;
    }
    if (!(o instanceof InteriorService)) {
      return false;
    }
    InteriorService that = (InteriorService) o;
    return numOfPets == that.numOfPets;
  }

  /**
   * Returns hashcode of the object
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numOfPets);
  }

}
