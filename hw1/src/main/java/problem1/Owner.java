package problem1;

/**
 * Owner is an object that has a first name, a last name, and a phone number.
 */
public class Owner {
    private String firstName;
    private String lastName;
    private String phoneNum;
    private static final int VALID_LENGTH = 10;

    /**
     * Constructor that creates a new Owner object with the specified firstName, lastName, and phoneNum.
     * @param firstName first name of the Owner
     * @param lastName last name of the Owner
     * @param phoneNum phone number of the Owner, length should be ten
     */
    public Owner(String firstName, String lastName, String phoneNum) {
        if (phoneNum.length() != VALID_LENGTH) {
            System.out.println("invalid phone number, should be length of 10");
        } else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNum = phoneNum;
        }
    }

    /**
     * Set firstName.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * set lastName.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * set phoneNum.
     * @param phoneNum
     */
    public void setPhoneNum(String phoneNum) {
        if (phoneNum.length() != VALID_LENGTH){
            System.out.println("invalid phone number, should be length of 10");
            this.phoneNum = null;
        }else {
            this.phoneNum = phoneNum;
        }
    }

    /**
     * return firstName.
     * @return firstName.
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * return lastName.
     * @return lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * return phoneNum.
     * @return phoneNum.
     */
    public String getPhoneNum() {
        return phoneNum;
    }

}
