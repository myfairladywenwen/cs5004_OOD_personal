package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private Person testPerson;
    private String firstName = "wen";
    private String lastName = "xie";


    @Before
    public void setUp() throws Exception {
        testPerson = new Person(firstName, lastName);
    }

    @Test
    public void getFirstName() {
        assertEquals(firstName, testPerson.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals(lastName, testPerson.getLastName());
    }

    @Test
    public void personEquals() {
        Person testPerson2 = new Person(firstName, lastName);
        assertTrue(testPerson.personEquals(testPerson2));
        Person testPerson3 = new Person(firstName + firstName, lastName);
        assertFalse(testPerson.personEquals(testPerson3));
        Person testPerson4 = new Person(firstName, lastName + lastName);
        assertFalse(testPerson.personEquals(testPerson4));
        Person testPerson5 = new Person(firstName + firstName, lastName + lastName);
        assertFalse(testPerson.personEquals(testPerson5));
    }
}