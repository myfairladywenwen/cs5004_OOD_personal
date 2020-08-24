package coursePackage;

public class Instructor {
    private String firstName, lastName;
    public Instructor(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
}
