import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {
    Author testAuthor;
    Person testPerson;
    Email testEmail;
    Address testAddress;

    @org.junit.Before
    public void setUp() throws Exception {
        testPerson = new Person("Wen", "Xie");
        testAddress = new Address(401, "Terry Ave N", "Seattle",
                "WA", 98109);
        testEmail = new Email ("wen","gmail.com");
        testAuthor = new Author(testPerson, testEmail, testAddress);
    }

    @Test
    public void testGetName() {
        assertEquals("Wen Xie", testAuthor.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("wen@gmail.com",
                testEmail.getLoginName()+"@"+testEmail.getDomain());
    }

    @Test
    public void testGetAddress() {
        assertEquals("401 Terry Ave N, Seattle WA 98109",
                testAuthor.getAddress());
    }
}

