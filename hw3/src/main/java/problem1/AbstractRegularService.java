package problem1;

/**
 * AbstractRegularService is a class extends AbstractService, will be extended by InteriorService
 * and ExteriorService
 */
public abstract class AbstractRegularService extends AbstractService {

  protected static final int BASE_RATE = 80;
  protected static final int HOUR_SMALL = 1;
  protected static final int HOUR_MED = 2;
  protected static final int HOUR_LARGE = 4;
  protected static final double MONTH_DISCOUNT = 0.9;
  protected static final double TENTH_DISCOUNT = 0.5;
  protected static final double COUNTS = 9;

  /**
   * Constructor for AbstractRegularService, won't be initialize here, just for subclasses
   *
   * @param address    - address of property, represented by a String
   * @param size       - size of property, represented by an Enum constant
   * @param monthly    - a boolean variable to represent whether the service is monthly carried
   * @param preService - an int variable of the number of pre-service of the property
   */
  public AbstractRegularService(String address, Size size, boolean monthly, int preService) {
    super(address, size, monthly, preService);
  }

  /**
   * calculate and update charge after monthly discount
   */
  protected void monthlyDiscount() {
    if ((this.monthly) && (this.preServices % COUNTS != 0)) {
      this.charge *= MONTH_DISCOUNT;
    }
  }

  /**
   * calculate and update charge after tenth discount
   */
  protected void tenthDiscount() {
    if (this.preServices % COUNTS == 0) {
      this.charge *= TENTH_DISCOUNT;
    }
  }

  /**
   * calculate and update charge
   */
  public double calculatePrice() {
    switch (this.size) {
      case SMALL:
        this.charge = HOUR_SMALL * BASE_RATE;
        return this.charge;
      case MED:
        this.charge = HOUR_MED * BASE_RATE;
        return this.charge;
      default://default is LARGE (so as test switch can reach 100% coverage)
        this.charge = HOUR_LARGE * BASE_RATE;
        return this.charge;
    }
  }

  //inherit equals and hashcode which have been overridden in AbstractService
}

