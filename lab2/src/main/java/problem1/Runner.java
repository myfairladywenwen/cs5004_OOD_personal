package problem1;

import java.util.Objects;

/**
 * Runner is an object extends Athlete, adding best5KTime, bestHalfMarathonTime, and favoriteEvent
 * fields.
 */
public class Runner extends Athlete {

  private Double best5KTime;
  private Double bestHalfMarathonTime;
  private String favoriteEvent;

  /**
   * Creates a Runner object with specified athletesName, height, weight, league, best5KTime,
   * bestHalfMarathonTime, adn favoriteEvent.
   * @param athletesName - object Name, containing athlete's first, middle and last name
   * @param height - athlete's height, expressed as a Double in cm
   *               (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
     @param league - athlete league
     @param best5KTime - athlete's best 5K time, expressed as a Double
     @param bestHalfMarathonTime - athlete's best best HalfMarathon time, expressed as a Double
     @param favoriteEvent - athlete's favoriteEvent, expressed as a String
   */
  public Runner(Name athletesName, Double height, Double weight, String league,
      Double best5KTime, Double bestHalfMarathonTime, String favoriteEvent) {
    super(athletesName, height, weight, league);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteEvent = favoriteEvent;
  }

  /**
   * Return best5KTime.
   *
   * @return best5KTime
   */
  public Double getBest5KTime() {
    return best5KTime;
  }

  /**
   * Return bestHalfMarathonTime.
   *
   * @return bestHalfMarathonTime
   */
  public Double getBestHalfMarathonTime() {
    return bestHalfMarathonTime;
  }

  /**
   * Return favoriteEvent.
   *
   * @return favoriteEvent
   */
  public String getFavoriteEvent() {
    return favoriteEvent;
  }

  /**
   * Set best5KTime.
   *
   * @param best5KTime athlete's best 5K time, expressed as a Double
   */
  public void setBest5KTime(Double best5KTime) {
    this.best5KTime = best5KTime;
  }

  /**
   * Set bestHalfMarathonTime.
   *
   * @param bestHalfMarathonTime athlete's best half Marathon time, expressed as a Double
   */
  public void setBestHalfMarathonTime(Double bestHalfMarathonTime) {
    this.bestHalfMarathonTime = bestHalfMarathonTime;
  }

  /**
   * Set favoriteEvent.
   *
   * @param favoriteEvent athlete's favoriteEvent, expressed as a String
   */
  public void setFavoriteEvent(String favoriteEvent) {
    this.favoriteEvent = favoriteEvent;
  }


  @Override
  /**
   * Check whether two Runners have the same athletesName, height, weight, league,
   * best5KTime, bestHalfMarathonTime, and favoriteEvent. Return true if they do,
   * otherwise return false.
   * @return true or false
   */
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Runner)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Runner runner = (Runner) o;
    return getBest5KTime().equals(runner.getBest5KTime()) &&
        getBestHalfMarathonTime().equals(runner.getBestHalfMarathonTime()) &&
        getFavoriteEvent().equals(runner.getFavoriteEvent());
  }

  @Override
  /**
   * Return the hashcode of the Runner.
   * @return Integer value of the Runner
   */
  public int hashCode() {
    return Objects
        .hash(super.hashCode(), getBest5KTime(), getBestHalfMarathonTime(), getFavoriteEvent());
  }

  @Override
  /**
   * Return a String to represent the Runner.
   * @return String
   */
  public String toString() {
    return "Runner{" +
        "best5KTime=" + best5KTime +
        ", bestHalfMarathonTime=" + bestHalfMarathonTime +
        ", favoriteEvent='" + favoriteEvent + '\'' +
        '}';
  }
}
