package problem2;

/**
 * Music is an object extends Item
 */
public class Music extends Item {

  /**
   * Constructs a Music with specified RecordingArtist creator, title and publish year
   *
   * @param creator     - a RecordingArtist
   * @param title       - a String
   * @param publishYear - an int
   */
  public Music(RecordingArtist creator, String title, int publishYear) {
    super(creator, title, publishYear);
  }

  /**
   * Constructs a Music with specified Group creator, title and publish year
   *
   * @param creator     - a Group
   * @param title       - a Sting
   * @param publishYear - an int
   */
  public Music(Group creator, String title, int publishYear) {
    super(creator, title, publishYear);
  }


  /**
   * check whether Music has the target creator
   *
   * @param creator - Target Creator being searched
   * @return true of false
   */
  @Override
  public boolean matchItemCreator(Creator creator) {
    return this.creator.isThisCreator(creator);
  }

  /**
   * Returns the String representation of the Music
   *
   * @return - a String representing of the Music
   */
  @Override
  public String toString() {
    return "Music{" +
        "creator=" + creator +
        ", title='" + title + '\'' +
        ", publishYear=" + publishYear +
        '}';
  }
}
