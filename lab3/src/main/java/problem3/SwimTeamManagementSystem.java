package problem3;

public interface SwimTeamManagementSystem {

  /**
   * Check whether or not the SwimTeamManagementSystem is empty
   * Returns true if is empty, otherwise return false
   * @return true or false
   */
  boolean isEmpty();

  /** Add a Swimmer to the SwimTeamManagementSystem.
   * (SwimTeamManagementSystem does not allow duplicates).
   * @param - a new swimmer to be added
   */
  void addSwimmer(Swimmer newSwimmer);

  /** Remove and return a specified Swimmer from the SwimTeamManagementSystem.
   * If the Swimmer doesn’t exist in the SwimTeamManagementSystem,
   * the system should throw SwimmerNotFoundException.
   * Returns the swimmer that has been removed.
   * @return Swimmer
  */
  Swimmer remove() throws SwimmerNotFoundException;

 /**
 * Check for a specified Swimmer in the SwimTeamManagementSystem
  * Returns the position of the specified Swimmer if it is in the system,
  * otherwise returns -1.
 */
  int check();

  /**
   * Count the number of Swimmers in the SwimTeamManagmenetSystem.
   * Returns the number
   * @return int
   */
  int count();

  /**
   * Find and return all Swimmers competing in a specified discipline.
   * If no Swimmers compete in the specified discipline, the system should throw a new
   * SwimmerNotFoundException.
   */
  Swimmer[] competingSwimmer() throws SwimmerNotFoundException;
}
