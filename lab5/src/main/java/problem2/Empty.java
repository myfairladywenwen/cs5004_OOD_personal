package problem2;

/**
 * Represents the empty Set of integers.
 */
public class Empty implements ISet {

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public ISet add(Integer element) {
    return new Cons(element, this);
  }


  @Override
  public boolean contains(Integer element){
    return false;
  }

  @Override
  public ISet remove(Integer element) {
    return this;
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

}
