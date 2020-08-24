package problem2;


public class Empty implements IBagOfWords {

  final static int HASH = 31;

  /**
   * Constructor
   */
  public Empty() {
  }


  /**
   * Creates and returns an empty ​BagOfWords
   *
   * @return - a new empty BagOfWords
   */
  static public Empty emptyBagOfWords() {
    return new Empty();
  }

  /**
   * Checks if the​ BagOfWords​ is empty. Returns true if the BagOfWords​ contains no items, false
   * otherwise.
   *
   * @return true or false
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Returns the number of elements in the ​BagOfWords​. Duplicates should be counted as separate
   * elements
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * Returns a new ​BagOfWords​ that contains all elements in the original ​BagOfWords​ plus ​s​.
   *
   * @param s - a String to add
   */
  @Override
  public IBagOfWords add(String s) {
    return new Cons(s, this);
  }

  /**
   * Checks if ​s ​is in the ​BagOfWords​. Returns true if the ​BagOfWords​ contains ​s​ and false
   * otherwise
   *
   * @param s - target String
   */
  @Override
  public Boolean contains(String s) {
    return false;
  }


  /**
   * Determine if two BagOfWords​ are equal(the order of words stored in ​BagOfWords​ does not
   * matter). If the exact same elements are present in both ​BagOfWords​, they should be equal.
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
    return "Empty{}";
  }
}
