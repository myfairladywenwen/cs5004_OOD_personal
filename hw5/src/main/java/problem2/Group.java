package problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Group is an object with specified name and a list of creators
 */
public class Group implements Creator {

  protected String name;
  protected ArrayList<RecordingArtist> list;

  /**
   * Constructs a Group with specified name and list of creators
   *
   * @param name - a String representing the Group's name
   * @param list - an ArrayList representing the Group's creators
   */
  public Group(String name, ArrayList<RecordingArtist> list) {
    this.name = name;
    this.list = list;
  }

  /**
   * Checks whether two Groups are same, return true if they have same name and list, otherwise
   * return false
   *
   * @param obj - object to be checked
   * @return - true or false
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (this.getClass() != obj.getClass())) {
      return false;
    }
    Group g = (Group) obj;
    return (this.name.equals(g.name)) && (this.list.equals(g.list));
  }

  /**
   * Returns an int representing the hashcode of the Group
   *
   * @return - int representing the hashcode of the Group
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, list);
  }

  /**
   * Returns the String representation of the Group
   *
   * @return - a String representing of the Group
   */
  @Override
  public String toString() {
    return "Group{" +
        "name='" + name + '\'' +
        ", list=" + list +
        '}';
  }

  /**
   * A helper to check whether the Group has the specified member
   *
   * @param creator - the target creator
   * @return - true of false
   */
  private boolean hasMemberInBand(Creator creator) {
    return list.contains(creator);
  }

  /**
   * Check whether the target creator is this object's creator
   *
   * @param creator - target creator
   * @return - true or false
   */
  @Override
  public boolean isThisCreator(Creator creator) {
    return this.hasMemberInBand(creator);
  }

}
