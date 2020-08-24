package problem2;
import java.util.Objects;

public class Node {
  private String item;
  private Node nextNode;

  /**
   * Constructor for a Node.
   * @param item The item to store.
   * @param nextNode A reference to the next Node, if any.
   */
  public Node(String item, Node nextNode) {
    this.item = item;
    this.nextNode = nextNode;
  }

  /**
   * Get the item in the Node.
   * @return The item.
   */
  public String getItem() {
    return this.item;
  }

  /**
   * Get the next Node.
   * @return The next Node, if present. Returns null if this is the end of the list.
   */
  public Node getNextNode() {
    return this.nextNode;
  }

  /**
   * Sets the next Node.
   * @param nextNode The next Node in the list. This will be null if the current Node is to be the end of the list.
   */
  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Node node = (Node) o;
    return Objects.equals(getItem(), node.getItem()) &&
        Objects.equals(getNextNode(), node.getNextNode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getItem(), getNextNode());
  }

  @Override
  public String toString() {
    return "Node{" +
        "item='" + item + '\'' +
        ", nextNode=" + nextNode +
        '}';
  }

  public int getSize(){
    if (nextNode == null) {
      return 1;
    }
    return 1 + nextNode.getSize();
  }
}

