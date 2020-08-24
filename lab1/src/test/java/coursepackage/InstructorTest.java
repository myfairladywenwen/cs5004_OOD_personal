package coursepackage;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstructorTest {
    Instructor testInstructor;
    String firstName = "Wen";
    String lastName = "Xie";
    @Before
    public void setUp() throws Exception {
        testInstructor = new Instructor(firstName, lastName);
    }

    @Test
    public void getFirstName() {
        assertEquals(firstName, testInstructor.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals(lastName, testInstructor.getLastName());
    }
}