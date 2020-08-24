package problem2;


/**
 * A Set is as in the mathematical notion of a set.
 */
public class Set {

  protected Integer[] myArray;
  protected int capacity;  // max number of elements the array can hold, initially to be 3
  private static final int INIT_CAPACITY = 3;
  protected int size;  // current number of elements in the array
  private static final int GROW_PROPORTION = 2;

  /**
   * Constructs a Set.
   */
  public Set() {
    this.capacity = INIT_CAPACITY;
    this.myArray = new Integer[capacity];
    this.size = 0;
  }

  /**
   * A helper method. Constructs a Set with specified capacity, underneath array and size
   *
   * @param capacity - the max number the Set can hold
   * @param myArray  -  the underneath array to hold the element of the set
   * @param size     - the current number the set has
   */
  private Set(int capacity, Integer[] myArray, int size) {
    this.capacity = capacity;
    this.myArray = myArray;
    this.size = size;
  }

  /**
   * Creates and returns an empty Set.
   *
   * @return a Set
   */
  public Set emptySet() {
    return new Set();
  }

  /**
   * A helper method. given a source array and a destination array, copy the value of the source
   * array to the destination array, copy starts from the srcPos index of the source array, to the
   * destPos of the destination array, in all, copy length items
   *
   * @param src     - the array to copy from
   * @param srcPos  - the position to start copy in the src
   * @param dest    - the array to copy to
   * @param destPos - the position to start copy in the dest
   * @param length  - how many elements we need to copy
   */
  private static void arrayCopy(Integer[] src, int srcPos, Integer[] dest, int destPos,
      int length) {
    for (int i = srcPos; i < srcPos + length; i++) {
      dest[destPos] = src[i];
      destPos++;
    }
  }

  /**
   * A helper method. Enlarge the underneath array by the given proportion times, copying all the
   * elements in the original array
   *
   * @param proportion - times of capacity return Integer array - a new enlarged array
   */
  private Integer[] resizeArray(int proportion) {
    Integer[] newArray = new Integer[proportion * capacity];
    Set.arrayCopy(this.myArray, 0, newArray, 0, size);
    //return new Set(2*capacity, newArray, size);
    return newArray;
  }

  /**
   * Adds the given Integer to the Set if and only if that Integer is not already in the Set.
   *
   * @param n - an Integer to be added
   * @return a new Set with the element added
   */
  public Set add(Integer n) {
    Set newSet;
    if (!this.contains(n)) {
      if (this.capacity == this.size) {
        //resize the underneath array
        Integer[] newArray = this.resizeArray(GROW_PROPORTION);
        //construct a new Set with bigger underneath array
        newSet = new Set(capacity * GROW_PROPORTION, newArray, this.size);
        //add n into it
        newSet.myArray[size] = n;
        newSet.size += 1;
        return newSet;
      }
      // if there is still enough place
      Integer[] myArrayCopy = new Integer[this.capacity];
      Set.arrayCopy(this.myArray, 0, myArrayCopy, 0, this.size);
      newSet = new Set(this.capacity, myArrayCopy, this.size);
      newSet.myArray[size] = n;
      newSet.size += 1;
      return newSet;
    } else {
      // return a copy of the original Set
      Integer[] myArrayCopy = new Integer[this.capacity];
      Set.arrayCopy(this.myArray, 0, myArrayCopy, 0, this.size);
      newSet = new Set(this.capacity, myArrayCopy, this.size);
      return newSet;
    }
  }

  /**
   * Returns true if the given Integer is in the Set, false otherwise
   *
   * @param n - Integer to check
   * @return true or false
   */
  public boolean contains(Integer n) {
    for (Integer element : this.myArray) {
      if (element != null && element.equals(n)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns a copy of the Set with the given Integer removed. If the given Integer is not in the
   * Set, returns the Set as is.
   *
   * @param n - Integer to be removed returns a Set
   * @return the new Set after doing the removal
   */

  public Set remove(Integer n) {
    int idx = this.findIdx(n);
    if (idx < 0) {
      return this;
    }
    //declare a new array to copy elements of the original array,
    //since we are to remove one element, this new array only need size - 1 spaces
    Integer[] newArray = new Integer[this.capacity];
    Set.arrayCopy(this.myArray, 0, newArray, 0, idx); //copy the first half
    Set.arrayCopy(this.myArray, idx + 1, newArray, idx, size - idx - 1); //copy the first half
    //construct a new Set using the new array
    return new Set(this.capacity, newArray, size - 1);
  }

  /**
   * a helper method. Find the index of n, if n is not in the Set, return -1
   *
   * @param n - the Integer to be located return int -index of n, if n is not in, return -1
   */
  private int findIdx(Integer n) {
    int idx = 0;
    while (idx < size) {
      if (this.myArray[idx] == n) {
        return idx;
      }
      idx++;
    }
    return -1;
  }

  /**
   * Gets the number of items in the Set. return an int
   * @return Integer - an int value of size
   */
  public Integer size() {
    return this.size;
  }

  /**
   * Check whether two sets have the same elements. Return true if they have, false otherwise.
   *
   * @param o - another set
   * @return true of false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || !(o instanceof Set)) {
      return false;
    }
    Set otherSet = (Set) o;
    return this.capacity == otherSet.capacity &&
        this.size == otherSet.size &&
        this.checkSetArrayEquals(otherSet);
    // check whether two Sets's underneath arrays have same elements
  }

  /**
   * Hashcode method for Set
   *
   * @return an int value representing the hashcode
   */
  @Override
  public int hashCode() {
    int hash = 0;
    for (Integer element : myArray) {
      if (element != null) {
        hash = hash * 31 + element;
      }
    }
    hash = hash * 31 + capacity;
    hash = hash * 31 + size;
    return hash;
  }

  /**
   * A helper method. Checks whether two underneath arrays of Set has same elements
   */
  private boolean checkSetArrayEquals(Set otherSet) {
    // now we are sure the two underneath array have same size
    for (int idx = 0; idx < size; idx++) {
      if (!this.contains(otherSet.myArray[idx])) {
        return false;
      }
    }
    return true;
  }

  /**
   * Return the String representation of the Set
   *
   * @return a String
   */
  @Override
  public String toString() {
    return "Set{" +
        "myArray= " + this.arrayString() +
        ", capacity=" + capacity +
        ", size=" + size +
        '}';
  }

  /**
   * A helper method Return the String representation of an array
   *
   * @return a String
   */
  private String arrayString() {
    String result = "[";
    String sep = "";
    for (int idx = 0; idx < this.size; idx++) {
      result += (sep + this.myArray[idx]);
      sep = ", ";
    }
    result += "]";
    return result;
  }
}
