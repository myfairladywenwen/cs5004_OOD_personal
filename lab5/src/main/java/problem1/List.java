package problem1;

/**
 * Represents a List of Integers
 */
public interface List {

    /**
     * Returns the total number of elements in the list.
     *
     * @return number of elements in this list
     */
    Integer size();


    /**
     * Returns true if empty and false otherwise
     *
     */
    Boolean isEmpty();

    /**
     * Given a new element {@code element} prepend it to this list
     *
     * @param element new element to add to the list
     * @return updated list with {@code element} prependeds
     */
    List add(Integer element);


    /**
     * Return the last element of this list.
     *
     * @return the last element of this list.
     */
    Integer last();


    /**
     * Return true if element is in the list and false otherwise.
     * @param element - target element
     * @return true of false
     */
    boolean contains(Integer element);

    /**
     * Returns the element found
     * @param index - target idx
     * @return - Integer at idx
     */
    Integer elementAt(Integer index) throws ElementNotInListException, IndexOutOfBoundsException;

    /**
     * return sum of list
     */
    Integer sum();

    /**
     * remove the element if it is in the list,
     * return a new list with this element removed
     */
    List removeElement(Integer element);

    /**
     * remove all occurrences of the element if it is in the list
     */
    List removeAllElement(Integer element);
}
