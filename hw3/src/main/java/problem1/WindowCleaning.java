package problem1;

import java.util.Objects;

/**
 * WindowCleaning is an object which extends ExteriorService
 */
public class WindowCleaning extends ExteriorService {

  private int numOfFloors; // max is 3, default is 0
  private static final int MAX_NUM_OF_FLOOR = 3;
  private static final double HIGH_FLOOR_CHARGE_RATE = 0.05;
  private static final int HIGH_FLOOR_CHARGE_COUNT = 1;

  /**
   * Constructor for WindowCleaning with specified address, size, monthly, preService and
   * nomOfFloors
   *
   * @param address     - address of property, represented by a String
   * @param size        - size of property, represented by an Enum constant
   * @param monthly     - a boolean to represent whether the service is monthly carried
   * @param preService  - an int value to represent the number of pre-service of the property
   * @param numOfFloors - an int value to represent the number of floors
   * @throws ExceedMaxFloorException - throws an ExceedMaxFloorException if exceed max number of
   *                                 floor
   */
  public WindowCleaning(String address, Size size, boolean monthly, int preService, int numOfFloors)
      throws ExceedMaxFloorException {
    super(address, size, monthly, preService);
    if (!exceedMaxFloor(numOfFloors)) {
      this.numOfFloors = numOfFloors;
    } else {
      throw new ExceedMaxFloorException(
          "can't provide window cleaning service for more than 3 floors.");
    }
  }

  /**
   * check whether the passing in numOfFloors has exceeded the limit
   *
   * @param numOfFloors - an int value to represent the number of floors
   * @return false if not exceeds, true if exceeds
   */
  private boolean exceedMaxFloor(int numOfFloors) {
    return numOfFloors > MAX_NUM_OF_FLOOR;
  }

  /**
   * Calculates and returns the final charge
   *
   * @return a double of charge
   */
  @Override
  public double calculatePrice() {
    super.calculatePrice();
    if (this.numOfFloors > HIGH_FLOOR_CHARGE_COUNT) {
      this.charge *= (1 + HIGH_FLOOR_CHARGE_RATE);
    }
    tenthDiscount();
    monthlyDiscount();
    return this.charge;
  }

  /**
   * check whether two object of WindowCleaningService class has same monthly, preServices, address,
   * size, and numOfFloors
   *
   * @param o - object to be compared
   * @return true if same, otherwise return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WindowCleaning)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    WindowCleaning that = (WindowCleaning) o;
    return numOfFloors == that.numOfFloors;
  }

  /**
   * Returns hashcode of the object
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numOfFloors);
  }

  /**
   * Return a String representation of the object
   *
   * @return a String
   */
  @Override
  public String toString() {
    return "WindowCleaning{" +
        "numOfFloors=" + numOfFloors +
        ", address='" + address + '\'' +
        ", size=" + size +
        ", monthly=" + monthly +
        ", preServices=" + preServices +
        '}';
  }
}
