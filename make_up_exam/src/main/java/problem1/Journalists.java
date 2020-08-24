package problem1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Journalists extends NewlyInfluencer {
  protected String pubCo;
  protected ArrayList<String> awards;
  protected static final double JOURNALIST_FACTOR = 0.85;
  protected static final int BUMP_FOLLOWER = 100000;
  protected static final double JOURNALIST_BUMP_FACTOR = 1.25;

  /**
   * Constructs a Journalist with specified name, dob, arraylist of soialmedia, and arraylist of
   * followers.
   *
   * @param name a String representing the name of the influencer
   * @param dob a LoacalDate representing the date of birth of the influencer
   * @param socialMeds an arraylist representing the social media of the influencer
   * @param numOfFollowers an arraylist representing the followers of the social media of the influencer
   * @param pubCo a String representing the publishing company
   * @param awards an arraylist representing the awards
   * @throws ImpactEstimationException throws ImpactEstimationException if less than 500000 followers
   */
  public Journalists(String name, LocalDate dob, ArrayList<SocialMed> socialMeds,
      ArrayList<Integer> numOfFollowers, String pubCo, ArrayList<String> awards)
      throws ImpactEstimationException {
    super(name, dob, socialMeds, numOfFollowers);
    this.pubCo = pubCo;
    this.awards = awards;
  }

  /**
   * Return the multiplier to multiply with the base impact.
   *
   * @return a Double representing the multiplier.
   */
  @Override
  protected Double getMuliplier() {
    return super.getMuliplier() * JOURNALIST_FACTOR * calBumpFactor();
  }


  /**
   * Calculate the bump factor of the journalist.
   * @return a Double representing the bump factor.
   */
  protected Double calBumpFactor(){
    for (int i = 0; i < this.socialMeds.size(); i++){
      if (socialMeds.get(i).equals(SocialMed.TWITTER)){
        if (this.numOfFollowers.get(i) > BUMP_FOLLOWER){
          return JOURNALIST_BUMP_FACTOR;
        }
      }
    }
    return 1.0;
  }

  /**
   * Check whether two Journalists are equal
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
    Journalists that = (Journalists) o;
    return pubCo.equals(that.pubCo) &&
        awards.equals(that.awards);
  }

  /**
   * returns an integer representing hashcode
   * @return an integer representing hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(pubCo, awards);
  }


  /**
   * returns a string representation of the object.
   * @return a string representation of the object
   */
  @Override
  public String toString() {
    return "Journalists{" +
        "pubCo='" + pubCo + '\'' +
        ", awards=" + awards +
        ", name='" + name + '\'' +
        ", dob=" + dob +
        ", socialMeds=" + socialMeds +
        ", numOfFollowers=" + numOfFollowers +
        '}';
  }
}
