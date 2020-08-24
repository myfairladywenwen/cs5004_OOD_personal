package problem2;

/**
 * Author is an object which has a firstname and lastname
 */
public class Author extends Person {  // implements Creator

  /**
   * Constructs an Author with specified firstname and lastname
   *
   * @param firstName - a String
   * @param lastName  - a String
   */
  public Author(String firstName, String lastName) {
    super(firstName, lastName);
  }

  //inherits equals, hashcode, isThisCreator from Person


  /**
   * Returns the String representation of the Author
   *
   * @return - a String representing of the Author
   */
  @Override
  public String toString() {
    return "Author{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
