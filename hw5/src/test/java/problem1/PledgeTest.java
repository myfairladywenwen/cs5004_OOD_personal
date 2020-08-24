package problem1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class PledgeTest {

  Pledge testP;

  @Before
  public void setUp() throws Exception {
    testP = new Pledge(10, LocalDate.of(2019, 1, 10),
        LocalDate.of(2020, 10, 1));
  }

  @Test
  public void testConstructor1() {
    testP = new Pledge(10, LocalDate.of(2021, 1, 10));
    assertEquals(testP.promiseDate, LocalDate.of(2021, 1, 10));
    assertEquals(10, testP.amount);
    assertEquals(LocalDate.now(), testP.creationDate);
  }

  @Test
  public void testConstructor2() {
    testP = new Pledge(10);
    assertEquals(10, testP.amount);
    assertEquals(LocalDate.now(), testP.creationDate);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalid() throws IllegalArgumentException {
    testP = new Pledge(10, LocalDate.of(2019, 1, 1),
        LocalDate.of(2018, 1, 1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalid1() throws IllegalArgumentException {
    testP = new Pledge(10, LocalDate.of(2019, 1, 1));
  }


  @Test
  public void setPromiseDate() {
    testP.setPromiseDate(LocalDate.of(2021, 10, 1));
    assertEquals(LocalDate.of(2021, 10, 1), testP.promiseDate);
  }

  @Test
  public void setPromiseDate1() {
    Pledge testP2 = new Pledge(10);
    testP2.setPromiseDate(LocalDate.of(2021, 10, 1));
    assertEquals(LocalDate.of(2021, 10, 1), testP2.promiseDate);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setPromiseDateInvalid() throws IllegalArgumentException {
    Pledge testP2 = new Pledge(10, LocalDate.of(2019, 1, 10),
        LocalDate.of(2020, 10, 1));
    testP2.setPromiseDate(LocalDate.of(2018, 10, 1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void setPromiseDateInvalid1() throws IllegalArgumentException {
    Pledge testP2 = new Pledge(10);
    testP2.setPromiseDate(LocalDate.of(2018, 10, 1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void setPromiseDateInvalid2() throws IllegalArgumentException {
    Pledge testP2 = new Pledge(10, LocalDate.of(2019, 10, 1),
        LocalDate.of(2020, 1, 1));
    testP2.setPromiseDate(LocalDate.of(2020, 10, 1));
  }

  @Test
  public void testEquals() {
    Pledge testP2 = new Pledge(10, LocalDate.of(2019, 1, 10),
        LocalDate.of(2020, 10, 1));
    assertTrue(testP.equals(testP2));
  }

  @Test
  public void testEquals1() {
    assertTrue(testP.equals(testP));
  }

  @Test
  public void testEquals2() {
    assertFalse(testP.equals(null));
    assertFalse(testP.equals("pledge"));
  }

  @Test
  public void testEquals3() {
    Pledge testP2 = new Pledge(20);
    assertFalse(testP.equals(testP2));
  }


  @Test
  public void testHashCode() {
    Pledge testP2 = new Pledge(10, LocalDate.of(2019, 1, 10),
        LocalDate.of(2020, 10, 1));
    assertEquals(testP.hashCode(), testP2.hashCode());
    testP2 = new Pledge(20);
    assertNotEquals(testP.hashCode(), testP2.hashCode());
  }

  @Test
  public void testToString() {
    String result = testP.toString();
    assertEquals("Pledge{promiseDate=2020-10-01, amount=10, creationDate=2019-01-10}", result);
  }

  @Test
  public void testGetContribute() {
    assertEquals(0, testP.getContribute(LocalDate.of(2000, 1, 1)));
  }

}