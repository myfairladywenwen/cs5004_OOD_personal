package problem2;

/**
 * Locker is an object which has a maxWidth, maxHeight, maxDepth and can hold a mailItem.
 */
public class Locker {

  private Integer maxWidth;
  private Integer maxHeight;
  private Integer maxDepth;
  private MailItem mailItem;
  private static final Integer SIZE = 1;

  /**
   * Constructs an empty Locker with specified maxWidth, maxHeight, maxDepth, will throw exception
   * if any dimension exceeds the requied SIZE.
   *
   * @param maxWidth   - max of width
   * @param maxHeight- max of width
   * @param maxDepth-  max of width
   * @throws IllegalArgumentException - report size provided is not legal
   */
  public Locker(Integer maxWidth, Integer maxHeight, Integer maxDepth)
      throws IllegalArgumentException {
    if (maxWidth < this.SIZE || maxHeight < this.SIZE || maxDepth < this.SIZE) {
      throw new IllegalArgumentException("illegal size");
    }
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
  }

  /**
   * Returns the maxWidth
   *
   * @return maxWidth
   */
  public Integer getMaxWidth() {
    return this.maxWidth;
  }

  /**
   * Returns the maxHeight
   *
   * @return maxHeight
   */
  public Integer getMaxHeight() {
    return this.maxHeight;
  }

  /**
   * Returns the maxDepth
   *
   * @return maxDepth
   */
  public Integer getMaxDepth() {
    return this.maxDepth;
  }


  /**
   * Returns the mailItem
   *
   * @return mailItem
   */
  public MailItem getMailItem() {
    return this.mailItem;
  }

  /**
   * Add a mailItem into the Locker it is empty and the item is smaller than the locker, otherwise
   * throw exception
   *
   * @param newMailItem - the item wanted to be added
   * @throws LockerOccupiedException   - report locker has been occupied
   * @throws ExceedLockerSizeException - report size provided is not legal
   */
  public void addMail(MailItem newMailItem)
      throws LockerOccupiedException, ExceedLockerSizeException {
    if (this.mailItem != null) {
      throw new LockerOccupiedException("locker is occupied");
    } else if (newMailItem.getWidth() > this.maxWidth || newMailItem.getHeight() > this.maxHeight
        || newMailItem.getDepth() > this.maxDepth) {
      throw new ExceedLockerSizeException("bigger than the locker");
    }
    this.mailItem = newMailItem;
  }

  /**
   * Pick up a mailItem from the locker, if the recepient is correct, and the locker does have an
   * item, otherwise throw exception.
   *
   * @param r - the recipient who wants to pick up item
   * @return mailItem
   * @throws EmptyLockerException        - report locker is empty
   * @throws UnmatchedRecipientException - report recipient not match
   */
  public MailItem pickUpMail(Recipient r) throws EmptyLockerException, UnmatchedRecipientException {
    if (this.mailItem == null) {
      throw new EmptyLockerException("locker is empty");
    } else if (!this.mailItem.getRecipient().equals(r)) {
      throw new UnmatchedRecipientException("recipient not match");
    }
    MailItem pickUpItem = this.mailItem;
    this.mailItem = null;
    return pickUpItem;
  }
}
