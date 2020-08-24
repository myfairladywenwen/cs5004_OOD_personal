package problem1;

/**
 * Schedule is an object that has Events, be it lunch or dinner, but only one for each.
 */
public class Schedule {

  private Lunch lunch;
  private Dinner dinner;

  /**
   * Constructs a Schedule object with lunch and dinner being null.
   */
  public Schedule() {
  }

  /**
   * Return the lunch
   *
   * @return lunch
   */
  public Lunch getLunch() {
    return this.lunch;
  }

  /**
   * Return the dinner
   *
   * @return dinner
   */
  public Dinner getDinner() {
    return this.dinner;
  }

  /**
   * check whether lunch is booked, return true if booked, otherwise return false.
   *
   * @return true or false
   */
  public boolean lunchIsBooked() {
    return this.lunch != null;
  }

  /**
   * check whether dinner is booked, return true if booked, otherwise return false.
   *
   * @return true or false
   */
  public boolean dinnerIsBooked() {
    return this.dinner != null;
  }

  /**
   * Add a lunch event to the schedule, if not already booked, otherwise throw an exception
   *
   * @param lunch - a lunch event
   * @throws EventAlreadyBookedException - report event has already been booked
   */
  public void bookLunch(Lunch lunch) throws EventAlreadyBookedException {
    if (lunchIsBooked()) {
      throw new EventAlreadyBookedException("Lunch has been booked");
    }
    this.lunch = lunch;
  }

  /**
   * Add a dinner event to the schedule, if not already booked, otherwise throw an exception
   *
   * @param dinner - a dinner event
   * @throws EventAlreadyBookedException - report event has already been booked
   */
  public void bookDinner(Dinner dinner) throws EventAlreadyBookedException {
    if (dinnerIsBooked()) {
      throw new EventAlreadyBookedException("Dinner has been booked");
    }
    this.dinner = dinner;
  }

}