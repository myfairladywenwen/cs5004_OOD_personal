package problem1;

import java.time.LocalDate;
import java.util.ArrayList;

public class NewlyInfluencer extends AbstractInfluencer  {
  protected static final int MIN_FOLLOWERS = 500000;

  /**
   * Constructs an NewlyInfluencer with specified name, dob, arraylist of soialmedia, and arraylist
   * of followers.
   *
   * @param name a String representing the name of the influencer
   * @param dob a LoacalDate representing the date of birth of the influencer
   * @param socialMeds an arraylist representing the social media of the influencer
   * @param numOfFollowers an arraylist representing the followers of the social media of the influencer
   * @throws ImpactEstimationException throws ImpactEstimationException if less than 500000 followers
   */
  public NewlyInfluencer(String name, LocalDate dob,
      ArrayList<SocialMed> socialMeds,
      ArrayList<Integer> numOfFollowers) throws ImpactEstimationException {
    super(name, dob, socialMeds, numOfFollowers);
    int total = this.getTotalFollowers();
    if (total < MIN_FOLLOWERS){
      throw new ImpactEstimationException("NewlyInfluencer should have more than 500000 followers");
    }
  }

  /**
   * return the total number of followers
   * @return an integer value representing total number of followers
   */
  protected int getTotalFollowers(){
    int total = 0;
    for (int num : this.numOfFollowers){
      total += num;
    }
    return total;
  }

  /**
   * return the estimate base influence according to general rule.
   *
   * @return - a Double representing estimated base influence.
   */
  @Override
  protected double estimateBase() {
    return getTotalFollowers();
  }

  /**
   * Return the multiplier to multiply with the base impact.
   *
   * @return a Double representing the multiplier.
   */
  @Override
  protected Double getMuliplier() {
    return 1.0;
  }

}
