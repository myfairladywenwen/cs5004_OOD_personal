package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RunnerTest {

  private Runner testRunner;
  private String testFName = "fname";
  private String testMName = "mname";
  private String testLName = "lname";
  private Name testName = new Name(testFName, testMName, testLName);
  private Double testHeight = 6.0;
  private Double testWeight = 140.0;
  private String testLeague = "SEALeague";
  private Double testBest5KTime = 30.00;
  private Double testBestHMTime = 500.00;
  private String testFavEvent = "ABC";

  @Before
  public void setUp() throws Exception {
    testRunner = new Runner(testName, testHeight, testWeight, testLeague,
        testBest5KTime, testBestHMTime, testFavEvent);
  }

  @Test
  public void getBest5KTime() {
    Double expected = testBest5KTime;
    assertEquals(Double.valueOf(expected), testRunner.getBest5KTime());
  }

  @Test
  public void getBestHalfMarathonTime() {
    Double expected = testBestHMTime;
    assertEquals(Double.valueOf(expected), testRunner.getBestHalfMarathonTime());
  }

  @Test
  public void getFavoriteEvent() {
    String expected = testFavEvent;
    assertEquals(expected, testRunner.getFavoriteEvent());
  }


  @Test
  public void setBest5KTime() {
    testRunner.setBest5KTime(40.0);
    assertEquals(Double.valueOf(40.0), testRunner.getBest5KTime());
  }

  @Test
  public void setBestHalfMarathonTime() {
    testRunner.setBestHalfMarathonTime(700.0);
    assertEquals(Double.valueOf(700.0), testRunner.getBestHalfMarathonTime());
  }

  @Test
  public void setFavoriteEvent() {
    testRunner.setFavoriteEvent("abc");
    assertEquals("abc", testRunner.getFavoriteEvent());
  }

  @Test
  public void testEquals() {
    assertTrue(testRunner.equals(testRunner));
    assertFalse(testRunner.equals(new Athlete(testName, testHeight, testWeight, testLeague)));
    assertTrue(testRunner.equals(
        new Runner(testName, testHeight, testWeight, testLeague,
            testBest5KTime, testBestHMTime, testFavEvent)));
    assertFalse(testRunner.equals(
        new Runner(testName, testHeight + testHeight, testWeight, testLeague,
            testBest5KTime, testBestHMTime, testFavEvent)));
    assertFalse(testRunner.equals(
        new Runner(testName, testHeight, testWeight + testWeight, testLeague,
            testBest5KTime, testBestHMTime, testFavEvent)));
    assertFalse(testRunner.equals(
        new Runner(testName, testHeight, testWeight, testLeague + testLeague,
            testBest5KTime, testBestHMTime, testFavEvent)));
    assertFalse(testRunner.equals(
        new Runner(testName, testHeight, testWeight, testLeague + testLeague,
            testBest5KTime, testBestHMTime, testFavEvent)));
    assertFalse(testRunner.equals(
        new Runner(testName, testHeight, testWeight, testLeague,
            testBest5KTime + testBest5KTime, testBestHMTime, testFavEvent)));

    assertFalse(testRunner.equals(
        new Runner(testName, testHeight, testWeight, testLeague,
            testBest5KTime, testBestHMTime + testBestHMTime, testFavEvent)));
    assertFalse(testRunner.equals(
        new Runner(testName, testHeight, testWeight, testLeague,
            testBest5KTime, testBestHMTime, testFavEvent + testFavEvent)));
  }

  @Test
  public void testHashCode() {
    assertEquals(1080841459, testRunner.hashCode());
  }

  @Test
  public void testToString() {
    String expected = "Runner{" +
        "best5KTime=" + testRunner.getBest5KTime() +
        ", bestHalfMarathonTime=" + testRunner.getBestHalfMarathonTime() +
        ", favoriteEvent='" + testRunner.getFavoriteEvent() + '\'' +
        '}';
    assertEquals(expected, testRunner.toString());
  }
}