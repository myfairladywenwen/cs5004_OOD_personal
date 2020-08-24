package problem2;

import java.util.Objects;

/**
 * Item is an abstract class which has a creator, a title, and a publishYear
 */
public abstract class Item {

  protected Creator creator;
  protected String title;
  protected int publishYear;

  /**
   * Constructs an Item with a specified creator, title and publishYear
   *
   * @param creator     - a creator
   * @param title       - a String
   * @param publishYear - an int
   */
  public Item(Creator creator, String title, int publishYear) {
    this.creator = creator;
    this.title = title;
    this.publishYear = publishYear;
  }

  /**
   * An abstract method which checks whether the called item has the same Creator with the passing
   * in argument. Return true if it has, otherwise return false.
   *
   * @param creator - Target Creator being searched
   * @return true or false
   */
  public abstract boolean matchItemCreator(Creator creator);

  /**
   * Checks whether two Items are same, return true if they have same publish year, creator, and
   * title otherwise return false
   *
   * @param o - object to be checked
   * @return - true or false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return publishYear == item.publishYear &&
        creator.equals(item.creator) &&
        title.equals(item.title);
  }

  /**
   * Returns an int representing the hashcode of the Item
   *
   * @return - int representing the hashcode of the Item
   */
  @Override
  public int hashCode() {
    return Objects.hash(creator, title, publishYear);
  }
}
