package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElecServiceTest {
  ElecService testES;
  Size size;

  @Before
  public void setUp() throws Exception {
    size = Size.SMALL;
    testES = new ElecService("address", size, true,9,1,false);
  }

  @Test (expected = ExceedMaxLicEmployeeException.class)
    public void constructorInvalid ()throws ExceedMaxLicEmployeeException{
      size = Size.SMALL;
      testES = new ElecService("address", size, true, 9, 5, false);
  }

  @Test
  public void calculatePrice() {
    assertEquals((200 * 1 + 50), testES.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice2()throws ExceedMaxLicEmployeeException {
    size = Size.SMALL;
    ElecService testES2 = new ElecService("address", size, true, 9, 1, true);
    assertEquals((200 * 2 + 50), testES2.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice3()throws ExceedMaxLicEmployeeException {
    size = Size.SMALL;
    ElecService testES2 = new ElecService("address", size, true, 9, 3, true);
    assertEquals((200 * 3 + 50), testES2.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice4()throws ExceedMaxLicEmployeeException {
    size = Size.LARGE;
    ElecService testES2 = new ElecService("address", size, true, 9, 2, true);
    assertEquals((200 * 3 + 50), testES2.calculatePrice(), 0.001);
  }
  @Test
  public void calculatePrice5()throws ExceedMaxLicEmployeeException {
    size = Size.LARGE;
    ElecService testES2 = new ElecService("address", size, true, 9, 3, true);
    assertEquals((200 * 3 + 50), testES2.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice6()throws ExceedMaxLicEmployeeException {
    size = Size.LARGE;
    ElecService testES2 = new ElecService("address", size, true, 9, 2, false);
    assertEquals((200 * 2 + 50), testES2.calculatePrice(), 0.001);
  }

  @Test
  public void calculatePrice7()throws ExceedMaxLicEmployeeException {
    size = Size.LARGE;
    ElecService testES2 = new ElecService("address", size, true, 9, 0, false);
    assertEquals((200 * 1 + 50), testES2.calculatePrice(), 0.001);
  }

  @Test
  public void testEquals() throws ExceedMaxLicEmployeeException {
    ElecService testES2 = new ElecService("address", Size.SMALL, true, 9, 0, false);
    ElecService testES3 = new ElecService("address", Size.SMALL, true, 9, 0, false);
    ElecService testES4 = new ElecService("address", Size.SMALL, true, 8, 0, false);
    assertTrue(testES2.equals(testES3));
    assertFalse(testES2.equals(testES4));

    assertTrue(testES2.equals(testES2));
    assertFalse(testES2.equals("2"));
  }

  @Test
  public void testHashcode() throws ExceedMaxLicEmployeeException{
    ElecService testES2 = new ElecService ("address", Size.SMALL, true,
        1, 1, true);
    assertEquals(-2036016334, testES2.hashCode());
  }

  @Test
  public void testToString(){
    String resultStr = "SpecialistService{numOfLicEmployees=1, isComplex=false, address='address',"
        + " size=SMALL, monthly=true, preServices=9}";
    assertEquals(resultStr, testES.toString());
  }

}