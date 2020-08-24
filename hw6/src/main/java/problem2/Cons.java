package problem2;

import java.lang.Object;
import java.util.ArrayList;
import java.util.Objects;

public class Cons implements IBagOfWords {

  final static int HASH = 31;

  private String word;
  private IBagOfWords rest;

  /**
   * Constructor
   *
   * @param s    - a String to add to the IBagOfWords
   * @param rest - a IBagOfWords
   */
  public Cons(String s, IBagOfWords rest) {
    this.word = s;
    this.rest = rest;
  }


  /**
   * Returns the first word of the bag
   *
   * @return - String representing the first word
   */
  public String getWord() {
    return word;
  }

  /**
   * Returns the rest of the bag
   *
   * @return - a Cons representing the rest
   */
  public IBagOfWords getRest() {
    return rest;
  }


  /**
   * Checks if the​ BagOfWords​ is empty. Returns true if the BagOfWords​ contains no items, false
   * otherwise.
   *
   * @return true or false
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Returns the number of elements in the ​BagOfWords​. Duplicates should be counted as separate
   * elements
   */
  @Override
  public Integer size() {
    return 1 + this.getRest().size();
  }

  /**
   * Returns a new ​BagOfWords​ that contains all elements in the original ​BagOfWords​ plus ​s​.
   *
   * @param s - a String to add
   */
  @Override
  public IBagOfWords add(String s) {
    if (this.getWord().compareTo(s) <= 0) {
      return new Cons(this.getWord(), this.rest.add(s));
    }
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
    if (this.getWord().equals(s)) {
      return true;
    }
    return this.getRest().contains(s);
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
    Cons c = (Cons) obj;
    return Objects.equals(this.word, c.word) && Objects.equals(this.rest, c.rest);
  }


  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.word, this.rest);
  }


  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Cons{" +
        "word=" + this.word
        + ", rest=" + this.getRest()
        + "}";
  }

}
