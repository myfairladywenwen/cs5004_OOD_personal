package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {
    private Vehicle testVehicle;
    private Integer testVIN = 111;
    private Integer testVIN2 = 222;
    private String testLicensePlate = "abc";
    private String testLicensePlate2 = "def";
    private String testFirstName = "wen";
    private String testLastName = "xie";
    private String testPhoneNum = "1112223333";
    private Owner testVOwner = new Owner(testFirstName,testLastName,testPhoneNum);

    @Before
    public void setUp() throws Exception {
        testVehicle = new Vehicle(testVIN, testLicensePlate, testVOwner);
    }

    @Test
    public void getVIN() {
        assertEquals(testVIN, testVehicle.getVIN());
    }

    @Test
    public void getLicensePlate() {
        assertEquals(testLicensePlate, testVehicle.getLicensePlate());
    }

    @Test
    public void setVIN() {
        testVehicle.setVIN(testVIN2);
        assertEquals(testVIN2, testVehicle.getVIN());
    }

    @Test
    public void setLicensePlate() {
        testVehicle.setLicensePlate(testLicensePlate2);
        assertEquals(testLicensePlate2, testVehicle.getLicensePlate());
    }

    @Test
    public void getVehicleOwner() {
        assertEquals(testVOwner, testVehicle.getVehicleOwner());
    }

    @Test
    public void setVehicleOwner() {
        Owner testVOwner2 = new Owner("w","x", "1112223333");
        testVehicle.setVehicleOwner(testVOwner2);
        assertEquals(testVOwner2, testVehicle.getVehicleOwner());
    }
}