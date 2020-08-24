package problem3;

/**
 * Person is an object that has a fistName and a lastName.
 */
public final class Person {
    private final String firstName;
    private final String lastName;

    /**
     * Constructor that creates a new Person object with the specified firstName and lastName.
     *
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Return firstName.
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Return lastName.
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * return true if the passing in Person has the same firstName and lastName with the calling object,
     * otherwise return false.
     *
     * @param anotherPerson
     * @return
     */
    public boolean personEquals(Person anotherPerson) {
        return this.firstName == anotherPerson.firstName &&
                this.lastName == anotherPerson.lastName;
    }
}
