package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AthleteTest {

  private Name testName;
  private Athlete testAthlete;
  private Athlete testAthlete3Argu;

  @Before
  public void setUp() throws Exception {
    testName = new Name("fname", "mname", "lname");
    testAthlete = new Athlete(testName, 6.0, 130.0, "SEALeague");
    testAthlete3Argu = new Athlete(testName, 6.0, 130.0);
  }

  @Test
  public void getAthletesName() {
    Name expectedName = new Name("fname", "mname", "lname");
    assertTrue(expectedName.equals(testAthlete.getAthletesName()));
  }

  @Test
  public void getHeight() {
    Double expectedHeight = 6.0;
    assertEquals(expectedHeight, testAthlete.getHeight());
  }

  @Test
  public void getWeight() {
    Double expectedWeight = 130.0;
    assertEquals(expectedWeight, testAthlete.getWeight());
  }

  @Test
  public void getLeague() {
    String expectedLeague = "SEALeague";
    assertEquals(expectedLeague, testAthlete.getLeague());
  }

  @Test
  public void setAthletesName() {
    Name testName2 = new Name("fname2", "mname2", "lname2");
    testAthlete.setAthletesName(testName2);
    assertEquals(testName2, testAthlete.getAthletesName());
  }

  @Test
  public void setHeight() {
    testAthlete.setHeight(5.0);
    assertEquals(Double.valueOf(5.0), testAthlete.getHeight());
  }

  @Test
  public void setWeight() {
    testAthlete.setWeight(140.0);
    assertEquals(Double.valueOf(140.0), testAthlete.getWeight());
  }

  @Test
  public void setLeague() {
    testAthlete.setLeague("SEA");
    assertEquals("SEA", testAthlete.getLeague());
  }

  @Test
  public void testToString() {
    String expectedString = "Athlete{" + "athletesName=" +
        testAthlete.getAthletesName().toString() +
        ", height=" + testAthlete.getHeight() +
        ", weight=" + testAthlete.getWeight() +
        ", league='" + testAthlete.getLeague() + '\'' +
        '}';
    assertEquals(expectedString, testAthlete.toString());
  }

  @Test
  public void testEquals() {
    assertTrue(testAthlete.equals(testAthlete));
    assertFalse(testAthlete.equals(testName));
    assertTrue(testAthlete.equals(
        new Athlete(testName, 6.0, 130.0, "SEALeague")));
    assertFalse(testAthlete.equals(
        new Athlete(testName, 4.0, 130.0, "SEALeague")));
    assertFalse(testAthlete.equals(
        new Athlete(testName, 6.0, 120.0, "SEALeague")));
    assertFalse(testAthlete.equals(
        new Athlete(testName, 6.0, 130.0, "SEAL")));
    assertFalse(testAthlete.equals(
        new Athlete(testName, 5.0, 130.5, "SEALeague")));
    assertFalse(testAthlete.equals(
        new Athlete(testName, 6.0, 130.0, "SEAL")));
    assertFalse(testAthlete.equals(
        new Athlete(testName, 6.0, 130.5, "SEAL")));
    assertFalse(testAthlete.equals(
        new Athlete(testName, 5.0, 130.5, "SEAL")));
    assertFalse(testAthlete.equals(
        new Athlete(new Name("ffname", "mmname", "llname"),
            5.0, 130.5, "SEA")));
  }

  @Test
  public void testHashCode() {
    assertEquals(69586128, testAthlete.hashCode());
  }
}