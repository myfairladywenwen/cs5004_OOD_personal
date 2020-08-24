package problem1;


public class EmptyPQ implements PriorityQueue {

  final static int HASH = 31;

  public EmptyPQ() {
  }

  /**
   * Creates and returns an empty PQ.
   *
   * @return - an empty PQ
   */
  static public EmptyPQ createEmpty() {
    return new EmptyPQ();
  }

  /**
   * Checks if PQ is empty. Returns true if the PQ contains no items, false otherwise.
   *
   * @return - true or false
   */
  @Override
  public boolean isEmpty() {
    return true;
  }

  /**
   * Adds the given element(the priority and its associated value) to the PQ.
   *
   * @param priority - an Integer representing priority
   * @param value    - a String representing value
   * @return - a new PQ
   */
  @Override
  public PriorityQueue add(Integer priority, String value) {
    return new ConsPQ(priority, value, this);
  }

  /**
   * Returns the ​value​ in the PQ that has the ​highest ​priority.
   *
   * @return - the String representing the value which has the highest priority
   */
  @Override
  public String peek() {
    return null;
  }

  /**
   * Returns a copy of the PQ without the element with the highest ​priority.
   *
   * @return - a PQ without the highest element throws - Calling ​pop()​ on an empty PQ will throw
   * an exception
   */
  @Override
  public PriorityQueue pop() throws PopOnEmptyPQException {
    throw new PopOnEmptyPQException("nothing to pop from an empty PQ.");
  }

  /**
   * Determine if two PriorityQueue are equal.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (obj.getClass() != this.getClass())) {
      return false;
    }
    return true;
  }


  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return HASH;
  }


  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "EmptyPQ{}";
  }


}
