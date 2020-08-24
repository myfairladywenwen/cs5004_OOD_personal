package problem1;

/**
 * Represents a non-empty list of integers
 *
 */
public class Cons implements List {
    private Integer first;
    private List rest;

    /**
     * Given an integer and a list create a new list with the
     * same elements as {@code rest} and with {@code first} prepended.
     *
     * @param first new element to add to the beginning of the list
     * @param rest the list we are going to use to add our new element
     */
    public Cons(Integer first, List rest) {
        this.first = first;
        this.rest = rest;
    }

    /**
     * Getter for property 'first'.
     *
     * @return Value for property 'first'.
     */
    public Integer getFirst() {
        return first;
    }

    /**
     * Getter for property 'rest'.
     *
     * @return Value for property 'rest'.
     */
    public List getRest() {
        return rest;
    }

    @Override
    public Integer size() {
        return 1 + this.getRest().size(); }

    @Override
    public Boolean isEmpty() {
        return false;
    }

    @Override
    public List add(Integer element) {

        return new Cons(element, this);
    }

    @Override
    public Integer last() {
        if (this.rest.isEmpty()) {
            return this.first;
        } else {
            return this.rest.last();
        }

    }

    @Override
    public boolean contains(Integer element){
        if (this.first.equals(element)){
            return true;
        }
        return this.rest.contains(element);
    }


    @Override
    public Integer elementAt(Integer index) throws IndexOutOfBoundsException{
        if (index > this.size()-1){
            throw new IndexOutOfBoundsException();
        }
        if (index.equals(0)){
            return this.first;
        }
        return this.rest.elementAt(index-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cons cons = (Cons) o;

        if (getFirst() != null ? !getFirst().equals(cons.getFirst()) : cons.getFirst() != null)
            return false;
        return getRest() != null ? getRest().equals(cons.getRest()) : cons.getRest() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirst() != null ? getFirst().hashCode() : 0;
        result = 31 * result + (getRest() != null ? getRest().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cons{"
            + "first=" + first
            + ", rest=" + rest
            + '}';
    }

    /**
     * return sum of list
     */
    @Override
    public Integer sum() {
        return first + this.rest.sum();
    }

    /**
     * remove the element if it is in the list, return a new list with this element removed
     *
     * @param element
     */
    @Override
    public List removeElement(Integer element) {
        if (!this.contains(element)) {
            return this;
        }
        if (this.first.equals(element)){
            return this.rest;
        }
        return new Cons(this.first, this.rest.removeElement(element));
    }

    /**
     * remove all occurrences of the element if it is in the list
     *
     * @param element
     */
    @Override
    public List removeAllElement(Integer element) {
        return this.first.equals(element) ? this.rest.removeAllElement(element) :
            new Cons(this.first, this.rest.removeAllElement(element));
    }
}
