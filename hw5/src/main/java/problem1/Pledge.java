package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Pledge is an object extending Donation, with specified amount of donation, and
 * a creationDate, and promiseDate, if provided.
 */
public class Pledge extends Donation {

  protected LocalDate promiseDate;

  /**
   * Constructs a Pledge donation with specified amount, creation date and promiseDate
   * @param amount - an int representing the amount of Donation
   * @param creationDate - a LocalDate object representing the creation date
   * @param promiseDate - a LocalDate object representing the promise date
   * @throws IllegalArgumentException - if creation date is in future, or
   * promise date is earlier than creation date, throw IllegalArgumentException
   */
  public Pledge(int amount, LocalDate creationDate, LocalDate promiseDate) throws IllegalArgumentException{
    super(amount, creationDate);
    if (promiseDate.isBefore(creationDate)){
      throw new IllegalArgumentException("promiseDate can not be in past.");
    }
    this.promiseDate = promiseDate;
  }

  /**
   * Constructs a Pledge donation with specified amount, and promise date,
   * and sets current date as creationDate
   * @param amount - an int representing the amount of Donation
   * @param promiseDate - a LocalDate object representing the promise date
   * @throws IllegalArgumentException - if promise date is earlier than creation date, throw IllegalArgumentException
   */
  public Pledge(int amount, LocalDate promiseDate) throws IllegalArgumentException{
    super(amount);
    if (promiseDate.isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("promiseDate can not be in past.");
    }
    this.promiseDate = promiseDate;
  }

  /**
   * Constructs a Pledge donation with specified amount,
   * sets the creatDate as current, and sets promiseDate to null
   * @param amount - an int representing the amount of Donation
   */
  public Pledge(int amount) {
    super(amount);
  }


  /**
   * Set/change the promiseDate
   * @param promiseDate - a LocalDate object representing the promise date
   * @throws IllegalArgumentException - if promise date is invalid, throw IllegalArgumentException
   */
  public void setPromiseDate(LocalDate promiseDate) throws IllegalArgumentException {
    if (this.promiseDate != null) {  // promiseDate has been set before
      if (this.promiseDate.isBefore(LocalDate.now())) {
        throw new IllegalArgumentException("Donation has occurred, can not set occurDate.");
      }
      else if (promiseDate.isBefore(this.creationDate)){
        throw new IllegalArgumentException("promise date can not set earlier creation date.");
      }
      this.promiseDate = promiseDate;
    } else {  // no promiseDate has been set
      if (promiseDate.isBefore(LocalDate.now())) {
        throw new IllegalArgumentException("can not set date earlier than now.");
      }
      this.promiseDate = promiseDate;
    }
  }

  /**
   * return the corresponding amount of donation within the specific period of time
   * @param dueDate - the specified time of inquiring amount of Donation
   * @return - an int representing the amount of Donation to the corresponding period
   */
  @Override
  int getContribute(LocalDate dueDate) {
    if (this.promiseDate.getYear() != dueDate.getYear()){
      return 0;
    } else{
      return this.amount;
    }
  }

  /**
   * Checks whether two Pledges are equal.  If they have the same amount and creationDate,
   * and promiseDate, return true, otherwise return false
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
    Pledge pledge = (Pledge) o;
    return promiseDate.equals(pledge.promiseDate);
  }

  /**
   * Return the hashcode of Monthly
   * @return - int representing the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), promiseDate);
  }

  /**
   * Return the String representation of the Pledge
   * @return - a String representing the Pledge donation
   */
  @Override
  public String toString() {
    return "Pledge{" +
        "promiseDate=" + promiseDate +
        ", amount=" + amount +
        ", creationDate=" + creationDate +
        '}';
  }


}
