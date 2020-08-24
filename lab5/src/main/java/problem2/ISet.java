package problem2;

/**
 * Represents a Set of Integers
 */
public interface ISet {

  /**
   * Returns the total number of elements in the Set.
   *
   * @return number of elements in this Set
   */
  Integer size();


  /**
   * Returns true if empty and false otherwise
   */
  Boolean isEmpty();

  /**
   * Given a new element add it to this Set
   *
   * @param element new element to add to the Set
   * @return updated Set with element added
   */
  ISet add(Integer element);


  /**
   * Return true if element is in the Set and false otherwise.
   *
   * @param element - target element
   * @return true of false
   */
  boolean contains(Integer element);

  /**
   * Remove the element from the Set, if it is in the Set,
   * Return the new Set with this element removed,
   * otherwise return the original Set
   */
  ISet remove(Integer element);

}
