package problem1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class ProfAthletes extends NewlyInfluencer{
  protected String sport;
  protected String profLeague;
  protected Double lastEarings;
  protected static final double ATHLETE_FACTOR = 0.95;


  /**
   * Constructs an ProfAthletes with specified name, dob, arraylist of soialmedia, and arraylist of
   * followers, sport, league and last season earings.
   *
   * @param name a String representing the name of the influencer
   * @param dob a LoacalDate representing the date of birth of the influencer
   * @param socialMeds an arraylist representing the social media of the influencer
   * @param numOfFollowers an arraylist representing the followers of the social media of the influencer
   * @param sport a String representing the sport
   * @param profLeague a String representing the league
   * @param lastEarings a Double representing the latest season earings
   * @throws ImpactEstimationException throws ImpactEstimationException if less than 500000 followers
   */
  public ProfAthletes(String name, LocalDate dob, ArrayList<SocialMed> socialMeds,
      ArrayList<Integer> numOfFollowers, String sport, String profLeague,
      Double lastEarings) throws ImpactEstimationException {
    super(name, dob, socialMeds, numOfFollowers);
    this.sport = sport;
    this.profLeague = profLeague;
    this.lastEarings = lastEarings;
  }

  /**
   * Return the multiplier to multiply with the base impact.
   *
   * @return a Double representing the multiplier.
   */
  @Override
  protected Double getMuliplier() {
    return super.getMuliplier() * ATHLETE_FACTOR;
  }

  /**
   * Check whether two ProfAtheletes are equal
   * @param o - object to be checked with
   * @return true or false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ProfAthletes that = (ProfAthletes) o;
    return sport.equals(that.sport) &&
        profLeague.equals(that.profLeague) &&
        lastEarings.equals(that.lastEarings);
  }

  /**
   * returns an integer representing hashcode
   * @return an integer representing hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(sport, profLeague, lastEarings);
  }

  /**
   * returns a string representation of the object.
   * @return a string representation of the object
   */
  @Override
  public String toString() {
    return "ProfAthletes{" +
        "sport='" + sport + '\'' +
        ", profLeague='" + profLeague + '\'' +
        ", lastEarings=" + lastEarings +
        ", name='" + name + '\'' +
        ", dob=" + dob +
        ", socialMeds=" + socialMeds +
        ", numOfFollowers=" + numOfFollowers +
        '}';
  }
}
