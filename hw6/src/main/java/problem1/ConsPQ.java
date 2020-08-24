package problem1;

/**
 * ConsPQ is a non empty PriorityQueue
 */
public class ConsPQ implements PriorityQueue {

  final static int HASH = 31;
  private int priority;
  private String value;
  private PriorityQueue rest;

  /**
   * Constructs a ConsPQ with specified element's priority and value, and specified PriorityQueue
   * being its rest
   *
   * @param priority - int representing the element's priority
   * @param value    - String representing the element's value
   * @param rest     - a PriorityQueue
   */
  public ConsPQ(int priority, String value, PriorityQueue rest) {
    this.priority = priority;
    this.value = value;
    this.rest = rest;
  }

  /**
   * returns the first element's priority
   *
   * @return - int representing the element's priority
   */
  public int getPriority() {
    return this.priority;
  }

  /**
   * returns the first element's value
   *
   * @return - String representing the element's priority
   */
  public String getValue() {
    return this.value;
  }

  /**
   * returns the PriorityQueue after the first element
   *
   * @return - a PriorityQueue
   */
  public PriorityQueue getRest() {
    return this.rest;
  }

  /**
   * Checks if PQ is empty. Returns true if the PQ contains no items, false otherwise.
   *
   * @return - true or false
   */
  @Override
  public boolean isEmpty() {
    return false;
  }

  /**
   * Adds the given element(the priority and its associated value) to the PQ. if the new element's
   * priority is high than or equals to the current PQ's first, put it in front of the current
   *
   * @param priority - an Integer representing priority
   * @param value    - a String representing value
   * @return - a new PQ
   */
  @Override
  public PriorityQueue add(Integer priority, String value) {
    if (priority >= this.priority) {
      return new ConsPQ(priority, value, this);
    }
    return new ConsPQ(this.priority, this.value, this.rest.add(priority, value));
  }

  /**
   * Returns the ​value​ in the PQ that has the ​highest ​priority. If two elements has same
   * priority, peek the first one
   *
   * @return - the String representing the value which has the highest priority
   */
  @Override
  public String peek() {
    return this.value;
  }

  /**
   * Returns a copy of the PQ without the element with the highest ​priority. If two elements has
   * same priority, pop the first one
   *
   * @return - a PQ without the highest(first) element throws - Calling ​pop()​ on an empty PQ will
   * throw an exception
   */
  @Override
  public PriorityQueue pop() throws PopOnEmptyPQException {
    return this.rest;
  }

  /**
   * Determine if two ConsPQ are equal.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (obj.getClass() != this.getClass())) {
      return false;
    }
    ConsPQ c = (ConsPQ) obj;
    if (this.getPriority() != c.getPriority()) {
      return false;
    }
    if (!this.getValue().equals(c.getValue())) {
      return false;
    }
    return this.getRest().equals(c.getRest());
  }


  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int result = this.getPriority();
    result = result * HASH + this.getValue().hashCode();
    if (this.getRest() != null) {
      result = result * HASH + this.getRest().hashCode();
    }
    return result;
  }


  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Cons{" +
        "priority=" + this.getPriority()
        + ", value=" + this.getValue()
        + ", rest=" + this.getRest()
        + "}";
  }


}
