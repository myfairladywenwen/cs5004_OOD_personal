package problem3;

import problem1.List;

public class EmptyLList implements LList {

  /**
   * Returns the total number of lists in the LList.
   *
   * @return number of elements in this LList
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * Returns the total number of elements in the LList.
   */
  @Override
  public Integer length() {
    return 0;
  }

  /**
   * returns the sum of all integers inside this list
   */
  @Override
  public Integer sum() {
    return 0;
  }

  /**
   * Returns true if empty and false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * takes a list of integers and prepends (adds) it to this list of list of integers
   *
   * @return a new updated list with element prependeds
   */
  @Override
  public LList add(List l) {
    return new ListOfList(l, this);
  }

  /**
   * takes an integer and removes the first occurrence of this integer in the list;
   *
   * @param element
   */
  @Override
  public LList removeInteger(Integer element) {
    return this;
  }

  /**
   * takes an integer and removes all occurrences of this integer in the list;
   *
   * @param element
   */
  @Override
  public LList removeAllInteger(Integer element) {
    return this;
  }
}
