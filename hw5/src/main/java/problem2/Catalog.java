package problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Catalog is a class which stores a collection of all the items in the library can search with
 * specific Creator.
 */
public class Catalog {

  protected ArrayList<Item> cataList;

  /**
   * Constructs an object of Catalog with specified list
   *
   * @param cataList - list of items that the Catalog has
   */
  public Catalog(ArrayList<Item> cataList) {
    this.cataList = cataList;
  }

  /**
   * Retrieve all items in the catalog(regardless of type), that have a title ​containing​ the
   * keyword
   *
   * @param keyword - a String representing the keyword
   * @return a list of items containing the keyword
   */
  public ArrayList<Item> search(String keyword) {
    ArrayList<Item> result = new ArrayList<>();
    for (Item item : this.cataList) {
      if (item.title.toLowerCase().contains(keyword.toLowerCase())) {
        result.add(item);
      }
    }
    return result;
  }

  /**
   * Retrieve books having exactly the target Author
   *
   * @param author - target author to be matched
   * @return a list of books matching the target author
   */
  public ArrayList<Item> search(Author author) {
    ArrayList<Item> result = new ArrayList<>();
    for (Item item : this.cataList) {
      if (item.matchItemCreator(author)) {
        result.add(item);
      }
    }
    return result;
  }

  /**
   * Retrieve Musics having exactly the target artist being the sole creator, or having the target
   * artist as a member of the creator group
   *
   * @param artist - target artist to be matched
   * @return a list of musics matching the target artist
   */
  public ArrayList<Item> search(RecordingArtist artist) {
    ArrayList<Item> result = new ArrayList<>();
    for (Item item : this.cataList) {
      if (item.matchItemCreator(artist)) {
        result.add(item);
      }
    }
    return result;
  }

  /**
   * Add an item into the Catalog
   *
   * @param i - item to be added
   */
  public void addItem(Item i) {
    if (i != null) {
      this.cataList.add(i);
    }
  }

  /**
   * removes the first occurrence of the specified element, if it is present. If the Catalog does
   * not contain the element, it remains unchanged.
   *
   * @param i - item to be removed
   * @throws EmptyCatalogException - throws EmptyCatalogException if the Catalog is empty
   */
  public void removeItem(Item i) throws EmptyCatalogException {
    if (this.isEmpty()) {
      throw new EmptyCatalogException("Catalog is empty");
    }
    this.cataList.remove(i);
  }

  /**
   * Return the number of items in the Calalog
   *
   * @return - int representing the size of the Calalog
   */
  public int size() {
    return this.cataList.size();
  }

  /**
   * Return whether the Catalog is empty.
   *
   * @return true or false.
   */
  public boolean isEmpty() {
    return this.cataList.isEmpty();
  }

  /**
   * Checks whether two Catalog are same Return true if they have same list(of items), otherwise
   * return false
   *
   * @param o - object to check equality
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
    Catalog catalog = (Catalog) o;
    return cataList.equals(catalog.cataList);
  }

  /**
   * Returns the hashcode of the Catalog
   *
   * @return - an int representing the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(cataList);
  }

  /**
   * Returns the String representation of the Catalog
   *
   * @return - a String representation of the Catalog
   */
  @Override
  public String toString() {
    return "Catalog{" +
        "cataList=" + cataList +
        '}';
  }
}
