package problem1;

/**
 * ExteriorService is an abstract class extends AbstractRegularService and will be extended by
 * GardeningService and WindowCleaningService
 */
public abstract class ExteriorService extends AbstractRegularService {

  /**
   * Constructor for ExteriorService, won't be initialize here, just for subclasses
   *
   * @param address    - address of property, represented by a String
   * @param size       - size of property, represented by an Enum constant
   * @param monthly    - a boolean variable to represent whether the service is monthly carried
   * @param preService - an int variable of the number of pre-service of the property
   */
  public ExteriorService(String address, Size size, boolean monthly, int preService) {
    super(address, size, monthly, preService);  //call the superclass SpecialService's constructor
  }

  //inherit equals and hashcode which have been overridden in AbstractService
  //inherit toString which have been overridden in AbstractService
}
