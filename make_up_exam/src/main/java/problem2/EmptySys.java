package problem2;

import java.util.HashMap;
import java.util.List;

public class EmptySys implements ISwimTeamManagementSystem{
  protected final static int HASH = 31;


  /**
   * Check whether or not the SwimTeamManagementSystem is empty.
   *
   * @return true or false
   */
  @Override
  public boolean isEmpty() {
    return true;
  }

  /**
   * Add a Swimmer to the SwimTeamManagementSystem. ISwimTeamManagementSystem does not allow
   * duplicates.
   *
   * @param s - Swimmer to add
   * @return - a new SwimTeamManagementSystem with added Swimmer
   */
  @Override
  public ISwimTeamManagementSystem add(Swimmer s) {
    return new Cons(s, this);
  }

  /**
   * Remove and return a specified Swimmer from the SwimTeamManagementSystem.
   *
   * @param s - Swimmer to remove
   * @return Swimmer - the removed Swimmer
   * @throws SwimmerNotFoundException - If the Swimmer doesn’t exist in the SwimTeamManagementSystem,
   *                                  the system should throw SwimmerNotFoundException
   */
  @Override
  public Swimmer remove(Swimmer s) throws SwimmerNotFoundException {
    throw new SwimmerNotFoundException("nothing to remove from empty system");
  }

  /**
   * @param s the Swimmer to check
   * @return true or false
   */
  @Override
  public boolean check(Swimmer s){
    return false;
  }

  /**
   * Count the number of Swimmers in the SwimTeamManagmenetSystem.
   *
   * @return integer representing the number of Swimmers
   */
  @Override
  public int count() {
    return 0;
  }

  /**
   * Find and return all Swimmers competing in a specified discipline
   *
   * @return a list of Swimmers found
   * @throws SwimmerNotFoundException If no Swimmers compete in the specified discipline, the system
   *                                  should throw a new SwimmerNotFoundException.
   */
  @Override
  public List<Swimmer> FindAllInDisipline(DisciplineType d) throws SwimmerNotFoundException {
    throw new SwimmerNotFoundException("nothing to found from an empty system");
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "EmptySys{}";
  }


  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return HASH;
  }

  /**
   * Determine if two EmptySys are equal.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (obj.getClass() != this.getClass())) {
      return false;
    }
    return true;
  }


}
