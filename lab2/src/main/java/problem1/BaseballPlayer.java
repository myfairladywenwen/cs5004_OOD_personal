package problem1;

import java.util.Objects;

/**
 * BaseballPlayer is an object extends Athlete, adding team, averageBatting, and
 * homeRuns fields.
 */
public class BaseballPlayer extends Athlete {
  private String team;
  private Double averageBatting;
  private Integer homeRuns;

  /**
   * Creates a BaseballPlayer object with specified athletesName, height, weight, league,
   * team, averageBatting, and homeRuns.
   *
   * @param athletesName - object Name, containing athlete's first, middle and last name
   * @param height represents athlete's height, expressed as a Double in cm
   *              (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param league - athlete league
   * @param team - athlete team
   * @param averageBatting - a Double representing average of batting
   * @param homeRuns - an Integer representing number of home runs
  */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league,
      String team, Double averageBatting, Integer homeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.averageBatting = averageBatting;
    this.homeRuns = homeRuns;
  }

  /**
   * Return team.
   * @return team
   */
  public String getTeam() {
    return team;
  }

  /**
   * Set team.
   *
   * @param team - athlete team
   */
  public void setTeam(String team) {
    this.team = team;
  }

  /**
   * Return averageBatting.
   * @return averageBatting
   */
  public Double getAverageBatting() {
    return averageBatting;
  }

  /**
   * Set averageBatting.
   *
   * @param averageBatting - a Double representing average of batting
   */
  public void setAverageBatting(Double averageBatting) {
    this.averageBatting = averageBatting;
  }

  /**
   * Return homeRuns.
   * @return homeRuns
   */
  public Integer getHomeRuns() {
    return homeRuns;
  }

  /**
   * Set homeRuns.
   * @param  homeRuns an Integer representing number of home runs
   */
  public void setHomeRuns(Integer homeRuns) {
    this.homeRuns = homeRuns;
  }

  @Override
  /**
   * Check whether two BaseballPlayers have the same athletesName, height, weight, league,
   * team, averageBatting , and homeRuns. Return true if they do,
   * otherwise return false.
   * @return true or false
   */
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BaseballPlayer)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    BaseballPlayer that = (BaseballPlayer) o;
    return getTeam().equals(that.getTeam()) &&
        getAverageBatting().equals(that.getAverageBatting()) &&
        getHomeRuns().equals(that.getHomeRuns());
  }

  @Override
  /**
   * Return the hashcode of the BaseballPlayer.
   * @return Integer value of the BaseballPlayer
   */
  public int hashCode() {
    return Objects.hash(super.hashCode(), getTeam(), getAverageBatting(), getHomeRuns());
  }

  @Override
  /**
   * Return a String to represent the BaseballPlayer.
   * @return BaseballPlayer
   */
  public String toString() {
    return "BaseballPlayer{" +
        "team='" + team + '\'' +
        ", averageBatting=" + averageBatting +
        ", homeRuns=" + homeRuns +
        '}';
  }
}
