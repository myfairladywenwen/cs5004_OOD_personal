package problem1;

import java.util.Objects;

/**
 * Event is an object which has a clientName and numOfPeople.
 */
public class Event {

  protected String clientName;
  protected Integer numOfPeople;

  /**
   * Constructs an Event object with specified clientName and numOfPeople.
   *
   * @param clientName  - name of the client, express as a String
   * @param numOfPeople - number of people of the event, should be greater than zero
   */
  public Event(String clientName, Integer numOfPeople) throws IllegalArgumentException {
    if (numOfPeople <= 0) {
      throw new IllegalArgumentException("number of people should be greater than zero");
    }
    this.clientName = clientName;
    this.numOfPeople = numOfPeople;
  }

  /**
   * Return clientName.
   *
   * @return clientName
   */
  public String getClientName() {
    return this.clientName;
  }

  /**
   * Set clientName.
   *
   * @param clientName name of the client, express as a String
   */
  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  /**
   * Return numOfPeople.
   *
   * @return numOfPeople
   */
  public Integer getNumOfPeople() {
    return this.numOfPeople;
  }

  /**
   * Set clientName.
   *
   * @param numOfPeople - number of people of the event, should be greater than zero
   */
  public void setNumOfPeople(Integer numOfPeople) {
    this.numOfPeople = numOfPeople;
  }

}
