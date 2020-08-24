package problem1;

import java.util.Objects;

/**
 * AbstractService is an abstract class that has address, size, monthly, preServices, and charge.
 */
public abstract class AbstractService implements ServiceMethod {

  protected String address;
  protected Size size;
  protected boolean monthly;
  protected int preServices;
  protected double charge; //default is 0

  /**
   * Constructor for AbstractService, won't be initialize here, just for subclasses
   *
   * @param address    - address of property, represented by a String
   * @param size       - size of property, represented by an Enum constant
   * @param monthly    - a boolean variable to represent whether the service is monthly carried
   * @param preService - an int variable of the number of pre-service of the property
   */
  public AbstractService(String address, Size size, boolean monthly, int preService) {
    this.address = address;
    this.size = size;
    this.monthly = monthly;
    this.preServices = preService;
  }

  /**
   * check whether two object of AbstractService class has same monthly, preServices, address and
   * size
   *
   * @param o - object to be compared
   * @return true if same, otherwise return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractService)) {
      return false;
    }
    AbstractService that = (AbstractService) o;
    return monthly == that.monthly &&
        preServices == that.preServices &&
        address.equals(that.address) &&
        size == that.size;
  }

  /**
   * Returns hashcode of the object
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(address, size.toString(), monthly, preServices);
  }

}
