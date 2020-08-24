package problem3;

import problem1.List;

public class ListOfList implements LList{
  private List first;
  private LList rest;

  public ListOfList(List first, LList rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Returns the total number of lists in the LList.
   *
   * @return number of elements in this LList
   */
  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }

  /**
   * Returns the total number of elements in the LList.
   */
  @Override
  public Integer length() {
    return this.first.size() + this.rest.length();
  }

  /**
   * returns the sum of all integers inside this list
   */
  @Override
  public Integer sum() {
    return this.first.sum() + this.rest.sum();
  }

  /**
   * Returns true if empty and false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return false;
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
    if (this.first.contains(element)){
        return new ListOfList(this.first.removeElement(element), this.rest);
    }
    return new ListOfList(this.first, this.rest.removeInteger(element));
  }

  /**
   * takes an integer and removes all occurrences of this integer in the list;
   *
   * @param element
   */
  @Override
  public LList removeAllInteger(Integer element) {
    return new ListOfList(this.first.removeAllElement(element),
        this.rest.removeAllInteger(element));
  }
}
