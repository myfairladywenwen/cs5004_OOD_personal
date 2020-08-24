package problem2;

import java.util.Objects;

/**
 * Recipient is an object which has a firstName, lastName, and email
 */
public class Recipient {

  private String firstName;
  private String lastName;
  private String email;

  /**
   * Constructs a Recipient object with specified firstName, lastName, and email
   *
   * @param firstName - a String representing firstName
   * @param lastName- a String representing lastName
   * @param email-    a String representing email
   */
  public Recipient(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * Returns firstName
   *
   * @return firstName
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Set the firstName
   *
   * @param firstName - a String representing firstName
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Returns lastName
   *
   * @return lastName
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Set the lastName
   *
   * @param lastName - a String representing lastName
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Return email
   *
   * @return email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Set the email
   *
   * @param email - a String representing email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Check whether two recipient has the same firstName, lastName and email. return true if they
   * have, otherwise return false
   *
   * @param o - another recipient to be compared
   * @return true or false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Recipient)) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return getFirstName().equals(recipient.getFirstName()) &&
        getLastName().equals(recipient.getLastName()) &&
        getEmail().equals(recipient.getEmail());
  }

  /**
   * Returns the hashcode of the recipient.
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getFirstName(), this.getLastName(), this.getEmail());
  }
}
