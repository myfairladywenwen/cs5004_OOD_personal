package problem1;

/**
 * ElecService is a class extends SpecialistService
 */
public class ElecService extends SpecialistService {

  private static final int PERMIT_FEE = 50;
  private static final int MAX_LIC_EMPLOYEE = 4;

  /**
   * Constructs an ElectService object with specified address, size, monthly, preServiece,
   * numOfEmployees, and isComplex.
   *
   * @param address           - address of property, represented by a String
   * @param size              - size of property, represented by an Enum constant
   * @param monthly           - a boolean to represent whether the service is monthly carried
   * @param preService        - an int value to represent the number of pre-service of the property
   * @param numOfLicEmployees - an int value to represent number of licensed employees
   * @param isComplex         - a boolean to represent whether it is a complex service
   * @throws ExceedMaxLicEmployeeException - throws an exception if number of employees exceed the
   *                                       max limit.
   */
  public ElecService(String address, Size size, boolean monthly, int preService,
      int numOfLicEmployees, boolean isComplex) throws ExceedMaxLicEmployeeException {
    super(address, size, monthly, preService, numOfLicEmployees, isComplex);
    if (numOfLicEmployees > MAX_LIC_EMPLOYEE) {
      throw new ExceedMaxLicEmployeeException("exceed max licensed employees.");
    }
  }

  /**
   * calculates and updates the original charge for the service.
   */
  @Override
  public double calculatePrice() {
    return super.calculatePrice() + PERMIT_FEE;
  }

  //inherit toString, equals, hashcode which have been overridden in SpecialService
}


