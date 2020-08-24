package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Monthly is an object extending Donation, with specified monthly amount of donation, and a
 * creation date, if provided.
 */
public class Monthly extends Donation {

  protected LocalDate cancelDate;
  protected static final int MONTHS_PER_YEAR = 12;

  /**
   * Constructs a Monthly donation with specified amount and creation date
   *
   * @param amount       - an int representing the amount of Donation
   * @param creationDate - a LocalDate object representing the creation date
   * @throws IllegalArgumentException - if creation date is in future, throw IllegalArgumentException
   */
  public Monthly(int amount, LocalDate creationDate) throws IllegalArgumentException {
    super(amount, creationDate);
  }

  /**
   * Constructs Monthly donation with specified amount and current date as creation date
   *
   * @param amount - an int representing the amount of Donation
   */
  public Monthly(int amount) {
    super(amount);
  }

  /**
   * Set cancel date of Monthly donation
   *
   * @param cancelDate - a LocalDate object representing the cancel date
   * @throws IllegalArgumentException - if cancel date is before creation date, throw
   *                                  IllegalArgumentException
   */
  public void setCancelDate(LocalDate cancelDate) throws IllegalArgumentException {
    if (cancelDate.isBefore(this.creationDate)) {
      throw new IllegalArgumentException("cancel date should not before creation.");
    }
    this.cancelDate = cancelDate;
  }

  /**
   * return the corresponding amount of donation within the specific period of time
   *
   * @param dueDate - the specified time of inquiring amount of Donation
   * @return - an int representing the amount of Donation to the corresponding period
   */
  @Override
  int getContribute(LocalDate dueDate) {
    if (this.creationDate.isBefore(dueDate)) {
      if (this.cancelDate == null) {  // not cancelled
        if (this.creationDate.getYear() == dueDate.getYear()) {  //creat and due are same year
          // creat: 2019.5.1                  due: 2019.12.31
          return this.amount * (this.creationDate.until(dueDate).getMonths() + 1);
        } else {  //creat and due are different years
          // creat: 2018.5.1                  due: 2019.12.31
          return this.amount * MONTHS_PER_YEAR;
        }
      } else {  // has cancel date
        if (this.cancelDate.getYear() < dueDate.getYear()) {  //canceled before the specific year
          // 2018.2.1 created   2018.5.1 canceled   2019.12.31 due
          return 0;
        } else if (this.cancelDate.getYear() > dueDate
            .getYear()) {  //canceled after the specific year
          if (this.creationDate.getYear() < dueDate
              .getYear()) {  //creat date before the specific year
            // 2018.4.5 created, 2020.10.10 cancel, 2019.12.31 due
            return this.amount * MONTHS_PER_YEAR;
          } else {  // create date is same as specific year
            //2019.4.5 created, 2020.10.1 cancel, 2019.12.31 due
            return this.amount * (this.creationDate.until(dueDate).getMonths() + 1);
          }
        } else { // canceled in the same specific year
          if (this.creationDate.getYear() < dueDate
              .getYear()) {  //creat date before the specific year
            if (this.creationDate.getDayOfMonth() < this.cancelDate.getDayOfMonth()) {
              // 2018.4.1 created, 2019.10.10 cancel, 2019.12.31 due
              return this.amount * (this.cancelDate.getMonthValue());
            } else {
              // 2018.4.15 created, 2019.10.10 cancel, 2019.12.31 due
              return this.amount * (this.cancelDate.getMonthValue() - 1);
            }
          } else {  // create date is same as specific year
            if (this.creationDate.getDayOfMonth() > this.cancelDate.getDayOfMonth()) {
              //2019.4.15 created, 2019.10.10 cancel, 2019.12.31 due
              return this.amount * (this.creationDate.until(this.cancelDate).getMonths() + 1);
            } else {
              //2019.4.5 created, 2019.10.10 cancel, 2019.12.31 due
              return this.amount * (this.creationDate.until(this.cancelDate).getMonths() + 1);
            }
          }
        }
      }
    }
    // 2020.2.1 created   2019.12.31 due
    return 0;
  }

  /**
   * Checks whether two Monthly are equal.  If they have the same amount and creationDate, and
   * cancel date, return true, otherwise return false
   *
   * @param o - the object to check with
   * @return - true or false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Monthly monthly = (Monthly) o;
    if (cancelDate != null) {
      return cancelDate.equals(monthly.cancelDate);
    }
    return true;
  }

  /**
   * Return the hashcode of Monthly
   *
   * @return - int representing the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), cancelDate);
  }

  /**
   * Return the String representation of the Monthly
   *
   * @return - a String representing the Monthly donation
   */
  @Override
  public String toString() {
    return "Monthly{" +
        "cancelDate=" + cancelDate +
        ", amount=" + amount +
        ", creationDate=" + creationDate +
        '}';
  }
}
