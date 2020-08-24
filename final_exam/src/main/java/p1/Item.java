package p1;

/**
 *Class represents a shopping item. A shopping item has a name, and a unit price.
 */
public class Item {
  private String name;
  private Float price;

  /**
   * Construct a Item object that has the
   * provided name and price
   *
   * @param name the name to be given to this shopping item
   * @param price the price to be given to this item
   */

  public Item(String name, Float price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public Float getPrice() {
    return price;
  }
}