package problem2;

/**
 * Creator is an interface with the method isThisCreator.
 */
public interface Creator {

  /**
   * Check whether the target creator is this object's creator
   *
   * @param creator - target creator
   * @return - true or false
   */
  boolean isThisCreator(Creator creator);

}
