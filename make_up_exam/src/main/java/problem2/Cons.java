package problem2;

import java.util.ArrayList;
import java.util.List;

public class Cons implements ISwimTeamManagementSystem {
  protected final static int HASH = 31;
  private ISwimTeamManagementSystem rest;
  private Swimmer first;

  public Cons(Swimmer first, ISwimTeamManagementSystem rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Check whether or not the SwimTeamManagementSystem is empty.
   *
   * @return true or false
   */
  @Override
  public boolean isEmpty() {
    return false;
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
    if (!check(s)) {
      return new Cons(s, this);
    }
    return this;
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
    if (this.first.equals(s)){
      return this.first;
    }
    return this.rest.remove(s);
  }

  /**
   * @param s the Swimmer to check
   * @return true or false
   */
  @Override
  public boolean check(Swimmer s) {
    if (this.first.equals(s)){
      return true;
    }
    return this.rest.check(s);
  }

  /**
   * Count the number of Swimmers in the SwimTeamManagmenetSystem.
   *
   * @return integer representing the number of Swimmers
   */
  @Override
  public int count() {
    return 1 + this.rest.count();
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
    List<Swimmer> list = new ArrayList<>();
    if (this.first.getDiscipline().equals(d)){
      list.add(this.first);
       this.rest.FindAllInDisipline(d).add(this.first);
      return list;
    }
    return this.rest.FindAllInDisipline(d);
  }


  /**
   * Determine if two Cons are equal.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (obj.getClass() != this.getClass())) {
      return false;
    }
    Cons c = (Cons) obj;
    if (!this.first.equals(c.first)) {
      return false;
    }
    return this.rest.equals(c.rest);

  }


  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int result = this.first.hashCode();
    result = result * HASH + this.first.hashCode();
    if (this.rest != null) {
      result = result * HASH + this.rest.hashCode();
    }
    return result;
  }


  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Cons{" +
        "first=" + this.first.toString()
        + ", rest=" + this.rest.toString()
        + "}";
  }

}
