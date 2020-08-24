package problem1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Celebrity extends AbstractInfluencer {
  protected String lastestEvent;

  /**
   * Constructs a celebrity
   * @param name a String representing the name of the influencer
   * @param dob a LoacalDate representing the date of birth of the influencer
   * @param socialMeds an arraylist representing the social media of the influencer
   * @param numOfFollowers an arraylist representing the followers of the social media of the influencer
   * @param lastestEvent a String representing the lastestEvent
   * @throws ImpactEstimationException throws ImpactEstimationException if younger than 18
   */
  public Celebrity(String name, LocalDate dob,
      ArrayList<SocialMed> socialMeds,
      ArrayList<Integer> numOfFollowers, String lastestEvent)
      throws ImpactEstimationException {
    super(name, dob, socialMeds, numOfFollowers);
    this.lastestEvent = lastestEvent;
  }

  /**
   * check whether two Celebrities are equal
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
    Celebrity celebrity = (Celebrity) o;
    return lastestEvent.equals(celebrity.lastestEvent);
  }

  /**
   * return the int representing the hashcode
   * @return int representing the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(lastestEvent);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Celebrity{" +
        "lastestEvent='" + lastestEvent + '\'' +
        ", name='" + name + '\'' +
        ", dob=" + dob +
        ", socialMeds=" + socialMeds +
        ", numOfFollowers=" + numOfFollowers +
        '}';
  }
}
