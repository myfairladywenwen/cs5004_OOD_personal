package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {
    private Owner testOwner;
    private String testFirstName = "wen";
    private String testFirstName2 = "wenwen";
    private String testLastName = "xie";
    private String testLastName2 = "Xie";
    private String testPhoneNum = "1112223333";
    private String testPhoneNumWrong = "123";

    @Before
    public void setUp() throws Exception {
        testOwner = new Owner(testFirstName,testLastName,testPhoneNum);
    }

    @Test
    public void constructorInvalid() {
        testOwner = new Owner(testFirstName,testLastName,testPhoneNumWrong);
        assertEquals(null, testOwner.getPhoneNum());
    }
    @Test
    public void setFirstName() {
        testOwner.setFirstName(testFirstName2);
        assertEquals(testFirstName2, testOwner.getFirstName());
    }

    @Test
    public void setLastName() {
        testOwner.setLastName(testLastName2);
        assertEquals(testLastName2, testOwner.getLastName());
    }

    @Test
    public void setPhoneNumValid() {
        testOwner.setPhoneNum(testPhoneNum);
        assertEquals(testPhoneNum, testOwner.getPhoneNum());
    }

    @Test
    public void setPhoneNumInvalid() {
        testOwner.setPhoneNum(testPhoneNumWrong);
        assertEquals(null, testOwner.getPhoneNum());
    }

    @Test
    public void getFirstName() {
        assertEquals(testFirstName, testOwner.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals(testLastName, testOwner.getLastName());
    }

    @Test
    public void getPhoneNum() {
        assertEquals(testPhoneNum, testOwner.getPhoneNum());
    }
}