package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerTest {

  private BaseballPlayer testBaseballPlayer;
  private String testFName = "fname";
  private String testMName = "mname";
  private String testLName = "lname";
  private Name testName = new Name(testFName, testMName, testLName);
  private Double testHeight = 6.0;
  private Double testWeight = 140.0;
  private String testLeague = "SEALeague";
  private String testTeam = "NEU";
  private Double testAverageBatting = 5.00;
  private Integer testHomeRuns = 5;

  @Before
  public void setUp() throws Exception {
    testBaseballPlayer = new BaseballPlayer(testName, testHeight, testWeight,
        testLeague, testTeam, testAverageBatting, testHomeRuns);
  }

  @Test
  public void getTeam() {
    assertEquals(testTeam, testBaseballPlayer.getTeam());
  }

  @Test
  public void setTeam() {
    testBaseballPlayer.setTeam("neu");
    assertEquals("neu", testBaseballPlayer.getTeam());
  }

  @Test
  public void getAverageBatting() {
    assertEquals(testAverageBatting, testBaseballPlayer.getAverageBatting());
  }

  @Test
  public void setAverageBatting() {
    testBaseballPlayer.setAverageBatting(6.00);
    assertEquals(Double.valueOf(6.00), testBaseballPlayer.getAverageBatting());
  }

  @Test
  public void getHomeRuns() {
    assertEquals(testHomeRuns, testBaseballPlayer.getHomeRuns());
  }

  @Test
  public void setHomeRuns() {
    testBaseballPlayer.setHomeRuns(6);
    assertEquals(Integer.valueOf(6), testBaseballPlayer.getHomeRuns());
  }

  @Test
  public void testEquals() {
    assertTrue(testBaseballPlayer.equals(testBaseballPlayer));
    assertFalse(testBaseballPlayer.equals(new Athlete(testName, testHeight,
        testWeight, testLeague)));
    assertTrue(testBaseballPlayer.equals(
        new BaseballPlayer(testName, testHeight, testWeight, testLeague,
            testTeam, testAverageBatting, testHomeRuns)));
    assertFalse(testBaseballPlayer.equals(
        new BaseballPlayer(testName, testHeight + testHeight, testWeight, testLeague,
            testTeam, testAverageBatting, testHomeRuns)));
    assertFalse(testBaseballPlayer.equals(
        new BaseballPlayer(testName, testHeight, testWeight + testWeight, testLeague,
            testTeam, testAverageBatting, testHomeRuns)));
    assertFalse(testBaseballPlayer.equals(
        new BaseballPlayer(testName, testHeight, testWeight, testLeague + testLeague,
            testTeam, testAverageBatting, testHomeRuns)));
    assertFalse(testBaseballPlayer.equals(
        new BaseballPlayer(testName, testHeight, testWeight, testLeague,
            testTeam + testTeam, testAverageBatting, testHomeRuns)));
    assertFalse(testBaseballPlayer.equals(
        new BaseballPlayer(testName, testHeight, testWeight, testLeague,
            testTeam, testAverageBatting + testAverageBatting, testHomeRuns)));

    assertFalse(testBaseballPlayer.equals(
        new BaseballPlayer(testName, testHeight, testWeight, testLeague,
            testTeam, testAverageBatting, testHomeRuns + testHomeRuns)));
  }

  @Test
  public void testHashCode() {
    assertEquals(253517492, testBaseballPlayer.hashCode());
  }

  @Test
  public void testToString() {
    String expected = "BaseballPlayer{" +
        "team='" + testBaseballPlayer.getTeam() + '\'' +
        ", averageBatting=" + testBaseballPlayer.getAverageBatting() +
        ", homeRuns=" + testBaseballPlayer.getHomeRuns() +
        '}';
    assertEquals(expected, testBaseballPlayer.toString());
  }
}