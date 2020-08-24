package authorPackage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {
    Email testEmail;
    String loginName = "wen";
    String domain = "gmail.com";

    @Before
    public void setUp() throws Exception {
        testEmail = new Email(loginName, domain);
    }

    @Test
    public void getLoginName() {
        assertEquals("wen", testEmail.getLoginName());
    }

    @Test
    public void getDomain() {
        assertEquals("gmail.com", testEmail.getDomain());
    }
}