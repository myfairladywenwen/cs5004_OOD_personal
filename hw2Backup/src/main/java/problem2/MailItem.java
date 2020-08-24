package problem2;

/**
 * MailItem is an object with a width, height and depth, recipient, and a specified minimal SIZE.
 */
public class MailItem {

  private Integer width;
  private Integer height;
  private Integer depth;
  private Recipient recipient;
  private static final Integer SIZE = 1;

  /**
   * Constructs a MailItem with specified width, height and depth, recipient; throw exception if any
   * dimension is smaller than SIZE.
   *
   * @param width      - width of MailItem
   * @param height-    height of MailItem
   * @param depth-     depth of MailItem
   * @param recipient- recipient of MailItem
   * @throws IllegalArgumentException - report size provided is not legal
   */
  public MailItem(Integer width, Integer height, Integer depth, Recipient recipient)
      throws IllegalArgumentException {
    if (width < this.SIZE || height < this.SIZE || depth < this.SIZE) {
      throw new IllegalArgumentException("illegal size");
    }
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;
  }

  /**
   * Returns width
   *
   * @return width
   */
  public Integer getWidth() {
    return this.width;
  }

  /**
   * Returns height
   *
   * @return height
   */
  public Integer getHeight() {
    return this.height;
  }

  /**
   * Returns depth
   *
   * @return depth
   */
  public Integer getDepth() {
    return this.depth;
  }

  /**
   * Returns recipient
   *
   * @return recipient
   */
  public Recipient getRecipient() {
    return this.recipient;
  }
}
