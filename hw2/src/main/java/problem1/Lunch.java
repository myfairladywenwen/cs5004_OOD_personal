package problem1;

/**
 * Lunch is an object extends Event, and adds numOfSandwich field; Lunch has its particular
 * requirement of number of people.
 */
public class Lunch extends Event {

  private static final Double RATIO_SANDWICH = 1.05;
  private static final int LOW_BOUND = 15;
  private static final int HIGH_BOUND = 90;
  private Integer numOfSandwich;

  /**
   * Constructs a lunch object with specified clientName, numOfPeople, from which can calculate and
   * has the numOfSandwich.
   *
   * @param clientName  - name of the client, express as a String
   * @param numOfPeople - number of people of the event, should be greater than zero
   */
  public Lunch(String clientName, Integer numOfPeople) throws IllegalArgumentException {
    super(clientName, numOfPeople);
    if (numOfPeople < this.LOW_BOUND || numOfPeople > this.HIGH_BOUND) {
      throw new IllegalArgumentException("number of people should between 15 and 90");
    }
    this.numOfSandwich = (int) Math.round(numOfPeople * this.RATIO_SANDWICH);
  }

  /**
   * Return the numberOfSandwich
   *
   * @return numberOfSandwich
   */
  public Integer getNumOfSandwich() {
    return this.numOfSandwich;
  }

}
