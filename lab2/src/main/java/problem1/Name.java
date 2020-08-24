package problem1;

import java.util.Objects;

public class Name {

  private String firstName;
  private String middleName;
  private String lastName;

  public Name() {
  }

  public Name(String firstName) {
    this.firstName = firstName;
  }

  public Name(String firstName, String middleName) {
    this.firstName = firstName;
    this.middleName = middleName;
  }

  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Name)) {
      return false;
    }
    Name name = (Name) o;
    return getFirstName().equals(name.getFirstName()) &&
        getMiddleName().equals(name.getMiddleName()) &&
        getLastName().equals(name.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getMiddleName(), getLastName());
  }

  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
