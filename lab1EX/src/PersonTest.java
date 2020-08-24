import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    Person testPerson;
    String firstName = "firstName";
    String lastName = "lastName";

    @Before
    public void setUp() throws Exception {
        testPerson = new Person(firstName, lastName);
    }

    @Test
    public void getFirstName() {
        assertEquals("firstName", testPerson.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("lastName", testPerson.getLastName());
    }
}