package problem1;

/**
 * PriorityQueue is a immutable list with elements in descending order as regard to their respective
 * priority.
 */
public interface PriorityQueue {

  /**
   * Creates and returns an empty PQ.
   * @return - an empty PQ
   */
  //static PriorityQueue creatEmpty(){
  //return new EmptyPQ();
  //};

  /**
   * Checks if PQ is empty. Returns true if the PQ contains no items, false otherwise.
   *
   * @return - true or false
   */
  boolean isEmpty();

  /**
   * Adds the given element(the priority and its associated value) to the PQ.
   *
   * @param priority - an Integer representing priority
   * @param value    - a String representing value
   * @return - a new PQ
   */
  PriorityQueue add(Integer priority, String value);

  /**
   * Returns the ​value​ in the PQ that has the ​highest ​priority. If two elements have same
   * priority, peek the first one
   *
   * @return - the String representing the value which has the highest priority
   */
  String peek();


  /**
   * Returns a copy of the PQ without the element with the highest ​priority. If two elements have
   * same priority, peek the first one
   *
   * @return - a PQ without the highest element
   * @throws PopOnEmptyPQException - Calling ​pop()​ on an empty PQ will throw an exception
   */
  PriorityQueue pop() throws PopOnEmptyPQException;


}
