package problem2;

import java.util.Objects;

public class LinkedListOfStrings implements IListOfStrings {

  private Node head;
  private int numNodes;

  public LinkedListOfStrings() {
    this.head = null;
    this.numNodes = 0;
  }

  public static LinkedListOfStrings createEmpty() {
    return new LinkedListOfStrings();
  }


  public void add(String item) {
    Node newNode = new Node(item, null);
    if (this.head == null)
      this.head = newNode;
    else {
      Node currNode = this.head;
      while (currNode.getNextNode() != null) {
        currNode = currNode.getNextNode();
      }
      currNode.setNextNode(newNode);
    }
    this.numNodes++;
  }

  @Override
  public boolean isEmpty() {
    return this.head == null;
  }

  @Override
  public int size() {
    if (isEmpty()) {
      return 0;
    }
    return this.head.getSize();
  }


  @Override
  public boolean contains(String input) {
    Node curr = this.head;
    while (curr != null){
      if (curr.getItem() == input){
        return true;
      }
      curr = curr.getNextNode();
    }
    return false;
  }

  /**
   * consumes another list of Strings, and checks that all elements
   * of this list are in the list passed as argument.
   * @param other
   * @return true/false
   */
  @Override
  public boolean containsAll(IListOfStrings other) {
    Node curr = this.head;
    while (curr != null) {
    if (other.contains(curr.getItem())) {
      curr = curr.getNextNode();
    } else{
      return false;
      }
    }
    return true;
  }

  /**
  takes the maximum String length, and returns a list
  with all elements whose length is greater than the maximum length removed.
   */
  @Override
  public IListOfStrings filerLargerThan(int max) {
    IListOfStrings newList = new LinkedListOfStrings();
    Node curr = this.head;
    while (curr != null){
      if (curr.getItem().length() <= max){
        ((LinkedListOfStrings) newList).add(curr.getItem());
      }
    }
    return newList;
  }

  /**
   *  check if the list has at least one duplicate element.
   * @return
   */
  @Override
  public boolean hasDuplicates() {
    Node curr = this.head;
    while(curr != null) {
      Node nextptr = curr.getNextNode();
      while (nextptr != null) {
        if (curr.getItem() == nextptr.getItem()) {
          return true;
        }
        nextptr = nextptr.getNextNode();
      }
      curr = curr.getNextNode();
    }
    return false;
  }

  /**
   *  returns the list with all duplicates removed.
   * @return
   */
  @Override
  public IListOfStrings removeDuplicates() {
//    Node curr = this.head;
//    Node currPrev = null;
//    while (curr != null) {
//      Node nextptr = curr.getNextNode();
//      Node nextpre = curr;
//      while (nextptr != null) {
//        if (curr.getItem() == nextptr.getItem()) {
//          prev.getNextNode() = nextptr.getNextNode();
//        }
//        prev = nextptr;
//        nextptr = nextptr.getNextNode();
//      }
//      currPrev = curr;
//      curr = curr.getNextNode();
//    }

    // do not know how to do
    return null;
  }

}