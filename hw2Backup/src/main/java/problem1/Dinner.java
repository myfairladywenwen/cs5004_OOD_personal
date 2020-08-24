package problem1;

/**
 * Lunch is an object extends Event, and adds numOfNonVeg and numOfVeg fields; Lunch has its
 * particular requirement of number of people.
 */
public class Dinner extends Event {

  private Integer numOfNonVeg;
  private Integer numOfVeg;
  private static final Double NON_VEG_RATIO = 0.8;
  private static final Double VEG_RATIO = 0.2;
  private static final int LOW_BOUND = 10;
  private static final int HIGH_BOUND = 50;

  /**
   * Constructs a dinner object with specified clientName, numOfPeople, from which can has the
   * corresponding numOfNonVeg and numOfVeg.
   *
   * @param clientName  - name of the client, express as a String
   * @param numOfPeople - number of people of the event, should be greater than zero
   */
  public Dinner(String clientName, Integer numOfPeople) throws IllegalArgumentException {
    super(clientName, numOfPeople);
    if (this.numOfPeople < this.LOW_BOUND || this.numOfPeople > this.HIGH_BOUND) {
      throw new IllegalArgumentException("number of people should between 10 and 50");
    }
    this.numOfNonVeg = (int) Math.round(this.NON_VEG_RATIO * this.numOfPeople);
    this.numOfVeg = (int) Math.round(this.VEG_RATIO * this.numOfPeople);
  }

  /**
   * Return the numOfNonVeg
   *
   * @return numOfNonVeg
   */
  public Integer getNumOfNonVeg() {
    return this.numOfNonVeg;
  }

  /**
   * Return the numOfVeg
   *
   * @return numOfVeg
   */
  public Integer getNumOfVeg() {
    return this.numOfVeg;
  }
}
