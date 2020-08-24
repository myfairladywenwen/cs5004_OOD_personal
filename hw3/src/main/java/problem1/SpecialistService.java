package problem1;

import java.util.Objects;

/**
 * SpecialistService is an abstract class which extends AbstractService and will be extended by
 * ElectService and PlumbService
 */
public abstract class SpecialistService extends AbstractService {

  protected int numOfLicEmployees; // >=1, default is 0
  protected boolean isComplex;  // default is false
  protected static final int BASE_RATE = 200;
  protected static final int S_M_COMPLEX_LIC_EMPLOYEE = 2;
  protected static final int L_COMPLEX_LIC_EMPLOYEE = 3;
  protected static final int NON_COMPLEX_MIN_LIC_EMPLOYEE = 1;

  /**
   * Constructor for SpecialService, won't be instantiated here, just for subclasses
   *
   * @param address           - address of property, represented by a String
   * @param size              - size of property, represented by an Enum constant
   * @param monthly           - a boolean to represent whether the service is monthly carried
   * @param preService        - an int value to represent the number of pre-service of the property
   * @param numOfLicEmployees - an int value to represent number of licensed employees
   * @param isComplex         - a boolean to represent whether it is a complex service
   * @throws ExceedMaxLicEmployeeException - throws an exception if number of employees exceed the
   *                                       max limit, will not throw any here, just for subclass.
   */
  public SpecialistService(String address, Size size, boolean monthly,
      int preService, int numOfLicEmployees, boolean isComplex)
      throws ExceedMaxLicEmployeeException {
    super(address, size, monthly, preService);  //call the superclass constructor
    if (isComplex) {
      switch (this.size) {
        case SMALL:
        case MED:
          if (numOfLicEmployees < S_M_COMPLEX_LIC_EMPLOYEE) {
            this.numOfLicEmployees = S_M_COMPLEX_LIC_EMPLOYEE;
          } else {
            this.numOfLicEmployees = numOfLicEmployees;
          }
          break;
        case LARGE:
          if (numOfLicEmployees < L_COMPLEX_LIC_EMPLOYEE) {
            this.numOfLicEmployees = L_COMPLEX_LIC_EMPLOYEE;
          } else {
            this.numOfLicEmployees = numOfLicEmployees;
          }
          break;
      }
    } else {
      if (numOfLicEmployees >= NON_COMPLEX_MIN_LIC_EMPLOYEE) {
        this.numOfLicEmployees = numOfLicEmployees;
      } else {
        this.numOfLicEmployees = NON_COMPLEX_MIN_LIC_EMPLOYEE;  //force it to be one
      }
    }
    this.isComplex = isComplex;
  }

  /**
   * Calculates and returns the final charge
   *
   * @return a double of charge
   */
  @Override
  public double calculatePrice() {
    this.charge = BASE_RATE * this.numOfLicEmployees;
    return this.charge;
  }

  /**
   * Return a String representation of the object
   *
   * @return a String
   */
  @Override
  public String toString() {
    return "SpecialistService{" +
        "numOfLicEmployees=" + numOfLicEmployees +
        ", isComplex=" + isComplex +
        ", address='" + address + '\'' +
        ", size=" + size +
        ", monthly=" + monthly +
        ", preServices=" + preServices +
        '}';
  }

  /**
   * check whether two object of SpecialService class has same monthly, preServices, address, size,
   * numOfLicEmployee, and isComplex
   *
   * @param o - object to be compared
   * @return true if same, otherwise return false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SpecialistService)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    SpecialistService that = (SpecialistService) o;
    return numOfLicEmployees == that.numOfLicEmployees &&
        isComplex == that.isComplex;
  }

  /**
   * Returns hashcode of the object
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numOfLicEmployees, isComplex);
  }
}
