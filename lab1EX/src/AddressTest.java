import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
    Address testAddress;
    int streetNo = 401;
    String streetName = "Teryy Ave N";
    String cityName = "Seattle";
    String stateAc = "WA";
    int zipcode = 98109;

    @Before
    public void setUp() throws Exception {
         testAddress = new Address(401, "Terry Ave N",
                "Seattle", "WA", 98109);
    }

    @Test
    public void getStreetNo() {
        assertEquals(401, testAddress.getStreetNo());
    }

    @Test
    public void getStreetName() {
        assertEquals("Terry Ave N", testAddress.getStreetName());
    }

    @Test
    public void getCityName() {
        assertEquals("Seattle", testAddress.getCityName());
    }

    @Test
    public void getStateAc() {
        assertEquals("WA", testAddress.getStateAc());
    }

    @Test
    public void getZipcode() {
        assertEquals(98109, testAddress.getZipcode());
    }

    @Test
    public void getAddress() {
        assertEquals("401 Terry Ave N, Seattle WA 98109", testAddress.getAddress());
    }
}