package problem2;



/**
 * Represents a non-empty Set of integers
 *
 */
public class Cons implements ISet {
  private Integer first;
  private ISet rest;

  /**
   * Given an integer and a Set create a new set with the
   * integer added into the set, if not already exists in the set
   *
   * @param first new element to add
   * @param rest the set we are going to use to add our new element
   */
  public Cons(Integer first, ISet rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Getter for property 'first'.
   *
   * @return Value for property 'first'.
   */
  public Integer getFirst() {
    return this.first;
  }

  /**
   * Getter for property 'rest'.
   *
   * @return Value for property 'rest'.
   */
  public ISet getRest() {
    return this.rest;
  }

  @Override
  public Integer size() {
    return 1 + this.getRest().size(); }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public ISet add(Integer element){
    if (this.contains(element)){
      return this;
    }
    return (new Cons(element, this));
  }


  @Override
  public boolean contains(Integer element){
    if (this.first.equals(element)){
      return true;
    }
    return this.rest.contains(element);
  }

  @Override
  public ISet remove(Integer element) {
    if (!this.contains(element)){
      return this;
    }
    if (this.first.equals(element)){
      return this.rest;  //return the set without the first element
    }
    return (new Cons(this.first, this.rest.remove(element)));
    //constructs a new set with first being its first, rest without the element being its rest
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


}
