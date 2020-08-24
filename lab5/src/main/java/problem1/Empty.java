package problem1;

/**
 * Represents the empty list of integers.
 */


public class Empty implements List {

    @Override
    public Integer size() {
        return 0;
    }

    @Override
    public Boolean isEmpty() {
        return true;
    }

    @Override
    public List add(Integer element) {
        return new Cons(element, this);
    }

    @Override
    public Integer last() throws InvalidCallException {
        throw new InvalidCallException("Called last() on empty!");
    }


    @Override
    public boolean contains(Integer element){
        return false;
    }


    @Override
    public Integer elementAt(Integer index) throws ElementNotInListException{
        throw new ElementNotInListException("element not in list");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        else return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public String toString() {
        return "Empty{}";
    }

    /**
     * return sum of list
     */
    @Override
    public Integer sum() {
        return 0;
    }

    /**
     * remove the element if it is in the list, return a new list with this element removed
     *
     * @param element
     */
    @Override
    public List removeElement(Integer element) {
        return this;
    }

    /**
     * remove all occurrences of the element if it is in the list
     *
     * @param element
     */
    @Override
    public List removeAllElement(Integer element) {
        return this;
    }
}
