package problem2;

import java.util.List;

/**
 * ISwimTeamManagementSystem is an interface that keep track of Swimmers.
 */
public interface ISwimTeamManagementSystem {

  /**
   * Check whether or not the SwimTeamManagementSystem is empty.
   * @return true or false
   */
  boolean isEmpty();


  /**
   * Add a Swimmer to the SwimTeamManagementSystem. ISwimTeamManagementSystem does not
   * allow duplicates.
   * @param s - Swimmer to add
   * @return - a new SwimTeamManagementSystem with added Swimmer
   */
  ISwimTeamManagementSystem add(Swimmer s);

  /**
   * Remove and return a specified Swimmer from the SwimTeamManagementSystem.
   * @param s - Swimmer to remove
   * @return Swimmer - the removed Swimmer
   * @throws SwimmerNotFoundException - If the Swimmer doesn’t exist in the SwimTeamManagementSystem, the system should throw SwimmerNotFoundException
   */
  Swimmer remove(Swimmer s) throws SwimmerNotFoundException;

  /**
   *
   * @param s the Swimmer to check
   * @return true or false
   */
  boolean check(Swimmer s);

  /**
   * Count the number of Swimmers in the SwimTeamManagmenetSystem.
    * @return integer representing the number of Swimmers
   */
  int count();

  /**
   * Find and return all Swimmers competing in a specified discipline
   * @param d the specified DisciplineType
   * @return a list of Swimmers found
   * @throws SwimmerNotFoundException If no Swimmers compete in the
   * specified discipline, the system should throw a new SwimmerNotFoundException.
   */
  List<Swimmer> FindAllInDisipline(DisciplineType d) throws SwimmerNotFoundException;


}
