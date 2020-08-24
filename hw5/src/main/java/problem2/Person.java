package problem2;

import java.util.Objects;

/**
 * Person is an object which has a firstName and lastName
 */
public class Person implements Creator{
  protected String firstName;
  protected String lastName;

  /**
   * Constructs a Person with specified firstName and lastName
   * @param firstName - a String
   * @param lastName - a String
   */
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Checks whether two Persons are same, returns true if
   * they have same firstName and same lastName, otherwise return false
   * @param obj - object to be checked
   * @return - true or false
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj){
      return true;
    }
    if ((this.getClass() != obj.getClass() || (obj ==null))){
      return false;
    }
    Person p = (Person)obj;
    return ((this.firstName == p.firstName) && (this.lastName == p.lastName));
  }

  /**
   * Returns an int representing the hashcode of the Person
   * @return - int representing the hashcode of the Person
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  /**
   * Check whether the target creator is this object's creator
   * @param creator - target creator
   * @return - true or false
   */
  @Override
  public boolean isThisCreator(Creator creator) {
    return this.equals(creator);
  }

}
