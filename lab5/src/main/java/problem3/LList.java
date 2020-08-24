package problem3;

import problem1.List;

/**
 * LList is a List of List of Integers
 */
public interface LList {
  /**
   * Returns the total number of lists in the LList.
   *
   * @return number of elements in this LList
   */
  Integer size();

  /**
   * Returns the total number of elements in the LList.
   *
   */
  Integer length();

  /**
   *  returns the sum of all integers inside this list
   */
  Integer sum();


  /**
   * Returns true if empty and false otherwise
   */
  Boolean isEmpty();

  /**
   * takes a list of integers and prepends (adds) it to this list of list of integers
   *  @return a new updated list with element prependeds
   */
   LList add(List l);


  /**
   * takes an integer and removes the first occurrence of this integer in the list;
   */
  LList removeInteger(Integer element);

  /**
   * takes an integer and removes all occurrences of this integer in the list;
   */
  LList removeAllInteger(Integer element);


}
