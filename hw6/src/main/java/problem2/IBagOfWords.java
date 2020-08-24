package problem2;

public interface IBagOfWords {

  /**
   * Checks if the​ BagOfWords​ is empty. Returns true if the BagOfWords​ contains no items, false
   * otherwise.
   *
   * @return true or false
   */
  Boolean isEmpty();

  /**
   * Returns the number of elements in the ​BagOfWords​. Duplicates should be counted as separate
   * elements
   *
   * @return - the size
   */
  Integer size();

  /**
   * Returns a new ​BagOfWords​ that contains all elements in the original ​BagOfWords​ plus ​s​.
   *
   * @param s - the string to be added
   * @return - a new IBagOfWords
   */
  IBagOfWords add(String s);

  /**
   * Checks if ​s ​is in the ​BagOfWords​. Returns true if the ​BagOfWords​ contains ​s​ and false
   * otherwise
   *
   * @param s - the target String to be checked
   * @return - true or false
   */
  Boolean contains(String s);

  /**
   * Determine if two BagOfWords​ are equal(the order of words stored in ​BagOfWords​ does not
   * matter). If the exact same elements are present in both ​BagOfWords​, they should be equal.
   */
  boolean equals(Object o);


  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  int hashCode();


  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  String toString();

}
