package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Donation is an abstract class that will be extended by Monthly, Onetime and Pledge.
 */
public abstract class Donation {

  protected int amount;
  protected LocalDate creationDate;

  /**
   * Constructs Donation with specified amount and creation date
   *
   * @param amount       - an int representing the amount of Donation
   * @param creationDate - a LocalDate object representing the creation date
   * @throws IllegalArgumentException - if creation date is in future, throw IllegalArgumentException
   */
  public Donation(int amount, LocalDate creationDate) throws IllegalArgumentException {
    if (creationDate.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("creationDate can not be in future.");
    }
    this.amount = amount;
    this.creationDate = creationDate;
  }

  /**
   * Constructs Donation with specified amount and current date as creation date
   *
   * @param amount - an int representing the amount of Donation
   */
  public Donation(int amount) {
    this.amount = amount;
    this.creationDate = LocalDate.now();
  }


  /**
   * return the corresponding amount of donation within the specific period of time
   *
   * @param dueDate - the specified time of inquiring amount of Donation
   * @return - an int representing the amount of Donation to the corresponding period
   */
  abstract int getContribute(LocalDate dueDate);

  /**
   * Checks whether two Donations are equal.  If they have the same amount and creationDate, return
   * true, otherwise return false
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
    Donation donation = (Donation) o;
    return amount == donation.amount &&
        creationDate.equals(donation.creationDate);
  }

  /**
   * Return the hashcode of Donation
   *
   * @return - int representing the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(amount, creationDate);
  }

}
