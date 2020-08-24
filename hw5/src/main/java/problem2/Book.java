package problem2;

/**
 * Book is an object extends Item
 */
public class Book extends Item {

  /**
   * Constructs a Book with specified author, title and publish year
   *
   * @param creator     - an Author
   * @param title       - a String
   * @param publishYear - an int
   */
  public Book(Author creator, String title, int publishYear) {
    super(creator, title, publishYear);
  }

  /**
   * Check whether the called book has the same creator(Author) as the target, return true if it
   * has, otherwise return false.
   *
   * @param creator - Target Creator being searched
   * @return true or false
   */
  public boolean matchItemCreator(Creator creator) {
    return this.creator.isThisCreator(creator);
  }

  /**
   * Returns the String representation of the Book
   *
   * @return - a String representing of the Book
   */
  @Override
  public String toString() {
    return "Book{" +
        "Author=" + creator +
        ", title='" + title + '\'' +
        ", publishYear=" + publishYear +
        '}';
  }
}
