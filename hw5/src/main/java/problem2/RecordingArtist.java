package problem2;

/**
 * RecordingArtist is an object extending Person.
 */
public class RecordingArtist extends Person {  // implements Creator

  /**
   * Constructs a RecordingArtist with specified firstName and lastName
   *
   * @param firstName - a String representing the firstName
   * @param lastName  - a String representing the LastName
   */
  public RecordingArtist(String firstName, String lastName) {
    super(firstName, lastName);
  }

  // inherit equals, hashcode and isThisCreator from Person


  /**
   * Returns the String representation of the RecordingArtist
   *
   * @return - a String representing of the RecordingArtist
   */
  @Override
  public String toString() {
    return "RecordingArtist{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
