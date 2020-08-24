package problem1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class AbstractInfluencer implements Iinfluencer {
  protected String name;
  protected LocalDate dob;
  protected ArrayList<SocialMed> socialMeds;
  protected ArrayList<Integer> numOfFollowers;
  protected static final double YOUTUBE_FACTOR = 0.9;
  protected static final double INS_FACTOR = 1.2;
  protected static final int MED_BUMP_SIZE = 3;
  protected static final double PLATFORM_BUMP = 1.6;
  protected static final int DISCOUNT_AGE = 40;
  protected static final double IMPACT_DISCOUNT = 0.55;
  protected static final int YOUNG = 18;

  /**
   * Constructs an AbstractInfluencer with specified name, dob, arraylist of soialmedia, and arraylist of followers.
   * @param name a String representing the name of the influencer
   * @param dob a LoacalDate representing the date of birth of the influencer
   * @param socialMeds an arraylist representing the social media of the influencer
   * @param numOfFollowers an arraylist representing the followers of the social media of the influencer
   * @throws ImpactEstimationException throws ImpactEstimationException if younger than 18
   */
  public AbstractInfluencer(String name, LocalDate dob,
      ArrayList<SocialMed> socialMeds, ArrayList<Integer> numOfFollowers) throws ImpactEstimationException{
    checkAge(dob);
    this.name = name;
    //this.dob = dob;
    this.socialMeds = socialMeds;
    this.numOfFollowers = numOfFollowers;
  }

  /**
   * Check whether the influencer is younger than 18 years old.
   * @param dob - LocalDate representing the date of birth of the influencer
   * @throws ImpactEstimationException - if the influencer is younger than 18, throw this exception.
   */
  protected void checkAge(LocalDate dob) throws ImpactEstimationException{
    if (LocalDate.now().getYear() - dob.getYear() < YOUNG){
      throw new ImpactEstimationException("can not estimate for younger than 18 years old influencer.");
    }
    this.dob = dob;
  }

  /**
   * estimate and return the influence
   *
   * @return a Double representing estimated influence.
   */
  @Override
  public Double estimateInfluence() {
    //return this.estimateBase() * this.platformBump() * this.ageImpactDiscount();
    return this.estimateBase() * this.getMuliplier();
  }


  /**
   * Return the multiplier to multiply with the base impact.
   * @return a Double representing the multiplier.
   */
  protected Double getMuliplier(){
    return this.platformBump() * this.ageImpactDiscount();
  }

  /**
   * return the estimate base influence according to general rule.
   * @return - a Double representing estimated base influence.
   */
  protected double estimateBase(){
    int sum = 0;
    Double result;
    for (int i = 0; i < this.socialMeds.size(); i++){
      switch (this.socialMeds.get(i)){
        case YOUTUBE:
          sum += this.numOfFollowers.get(i) * YOUTUBE_FACTOR;
        case INSTAGRAM:
          sum += this.numOfFollowers.get(i) * INS_FACTOR;
        default:
          sum += this.numOfFollowers.get(i);
      }
    }
    result =  (double)sum/this.socialMeds.size();
    return result;
  }

  /**
   * return the factor for platform bump when there are more than 3 social media.
   * @return - a Double representing platform bump
   */
  protected Double platformBump(){
    if (this.socialMeds.size() > MED_BUMP_SIZE){
      return PLATFORM_BUMP;
    }
    return 1.0;
  }

  /**
   * return the factor for age impact discount.
   * @return - a Double representing age impact discount
   */
  protected Double ageImpactDiscount(){
    if (LocalDate.now().getYear() - this.dob.getYear() >= DISCOUNT_AGE){
      return IMPACT_DISCOUNT;
    }
    return 1.0;
  }


  /**
   * check whether two AbstractInfluencers are equal
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
    AbstractInfluencer that = (AbstractInfluencer) o;
    return name.equals(that.name) &&
        dob.equals(that.dob) &&
        socialMeds.equals(that.socialMeds) &&
        numOfFollowers.equals(that.numOfFollowers);
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   * <p>
   * The {@code equals} method implements an equivalence relation on non-null object references:
   * <ul>
   * <li>It is <i>reflexive</i>: for any non-null reference value
   *     {@code x}, {@code x.equals(x)} should return
   *     {@code true}.
   * <li>It is <i>symmetric</i>: for any non-null reference values
   *     {@code x} and {@code y}, {@code x.equals(y)}
   *     should return {@code true} if and only if
   *     {@code y.equals(x)} returns {@code true}.
   * <li>It is <i>transitive</i>: for any non-null reference values
   *     {@code x}, {@code y}, and {@code z}, if
   *     {@code x.equals(y)} returns {@code true} and
   *     {@code y.equals(z)} returns {@code true}, then
   *     {@code x.equals(z)} should return {@code true}.
   * <li>It is <i>consistent</i>: for any non-null reference values
   *     {@code x} and {@code y}, multiple invocations of
   *     {@code x.equals(y)} consistently return {@code true}
   *     or consistently return {@code false}, provided no
   *     information used in {@code equals} comparisons on the
   *     objects is modified.
   * <li>For any non-null reference value {@code x},
   *     {@code x.equals(null)} should return {@code false}.
   * </ul>
   * <p>
   * The {@code equals} method for class {@code Object} implements
   * the most discriminating possible equivalence relation on objects;
   * that is, for any non-null reference values {@code x} and
   * {@code y}, this method returns {@code true} if and only
   * if {@code x} and {@code y} refer to the same object
   * ({@code x == y} has the value {@code true}).
   * <p>
   * Note that it is generally necessary to override the {@code hashCode}
   * method whenever this method is overridden, so as to maintain the
   * general contract for the {@code hashCode} method, which states
   * that equal objects must have equal hash codes.
   *
   * @param obj the reference object with which to compare.
   * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
   * @see #hashCode()
   * @see HashMap
   */


  /**
   * Returns a string representation of the object. In general, the {@code toString} method returns
   * a string that "textually represents" this object. The result should be a concise but
   * informative representation that is easy for a person to read. It is recommended that all
   * subclasses override this method.
   * <p>
   * The {@code toString} method for class {@code Object} returns a string consisting of the name of
   * the class of which the object is an instance, the at-sign character `{@code @}', and the
   * unsigned hexadecimal representation of the hash code of the object. In other words, this method
   * returns a string equal to the value of:
   * <blockquote>
   * <pre>
   * getClass().getName() + '@' + Integer.toHexString(hashCode())
   * </pre></blockquote>
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "AbstractInfluencer{" +
        "name='" + name + '\'' +
        ", dob=" + dob +
        ", socialMeds=" + socialMeds +
        ", numOfFollowers=" + numOfFollowers +
        '}';
  }
}
