package problem1;

import java.time.LocalDate;

/**
 * OneTime is an object of specified amount with or without a specified creationDate
 */
public class OneTime extends Donation {

  /**
   * Constructs a OneTime donation with specified amount and creationDate
   *
   * @param amount       - an int of amount of donation
   * @param creationDate - a LocalDate of the creationDate
   * @throws IllegalArgumentException - if creationDate is after current, throw IllegalArgumentException
   */
  public OneTime(int amount, LocalDate creationDate) throws IllegalArgumentException {
    super(amount, creationDate);
  }

  public OneTime(int amount) {
    super(amount);
  }


  int getContribute(LocalDate dueDate) {
    if (this.creationDate.getYear() == dueDate.getYear()) {
      return this.amount;
    }
    return 0;
  }

}
