package problem2;

import java.util.Arrays;
import java.util.Objects;

/*
 * Class Swimmer includes information about a swimmer, used in the SwimTeamManagementSystem.
 */
public class Swimmer {

  private String name;
  private DisciplineType discipline;
  private Double time;
  private String[] clubs;
  private String[] coaches;

  /*
   * Constructs an object swimmer, based on the provided input arguments:
   * @param name - swimmer's name, represented as a String
   * @param discipline - swimmer's discipline, represented as one possible option from an
   * enumeration DisciplineType
   * @param time - swimmer's best swim time in the defined discipline
   * @param clubs - swimmer's clubs
   * @param coaches - swimmer's coaches
   */
  public Swimmer(String name, DisciplineType discipline, Double time, String[] clubs, String[] coaches) {
    this.name = name;
    this.discipline = discipline;
    this.time = time;
    this.clubs = clubs;
    this.coaches = coaches;
  }

  /*
   * Getter for the swimmer's name.
   * @return name - swimmer's name as a String
   */
  public String getName() {
    return name;
  }

  /*
   * Setter for the swimmer's name.
   * @param name - swimmer's name as a String
   */
  public void setName(String name) {
    this.name = name;
  }


  /*
   * Getter for the swimmer's discipline.
   * @return discipline - swimmer's discipline as a DisciplineType
   */
  public DisciplineType getDiscipline() {
    return discipline;
  }

  /*
   * Setter for the swimmer's discipline.
   * @param discipline - swimmer's discipline as a DisciplineType
   */
  public void setDiscipline(DisciplineType discipline) {
    this.discipline = discipline;
  }

  /*
   * Getter for the swimmer's time.
   * @return time - swimmer's best time as a Double
   */
  public Double getTime() {
    return time;
  }

  /*
   * Setter for the swimmer's time.
   * @param time - swimmer's best time as a Double
   */
  public void setTime(Double time) {
    this.time = time;
  }

  /*
   * Getter for the swimmer's clubs.
   * @return clubs - swimmer's clubs as an array of Strings
   */
  public String[] getClubs() {
    return clubs;
  }

  /*
   * Setter for the swimmer's clubs.
   * @param clubs - swimmer's clubs as an array of Strings
   */
  public void setClubs(String[] clubs) {
    this.clubs = clubs;
  }

  /*
   * Getter for the swimmer's coaches.
   * @return coaches - swimmer's coaches as an array of Strings
   */
  public String[] getCoaches() {
    return coaches;
  }

  /*
   * Setter for the swimmer's coaches.
   * @param coaches - swimmer's coaches as an array of Strings
   */
  public void setCoaches(String[] coaches) {
    this.coaches = coaches;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Swimmer)) return false;
    Swimmer swimmer = (Swimmer) o;
    return Objects.equals(getName(), swimmer.getName()) &&
        getDiscipline() == swimmer.getDiscipline() &&
        Objects.equals(getTime(), swimmer.getTime()) &&
        Arrays.equals(getClubs(), swimmer.getClubs()) &&
        Arrays.equals(getCoaches(), swimmer.getCoaches());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getName(), getDiscipline(), getTime());
    result = 31 * result + Arrays.hashCode(getClubs());
    result = 31 * result + Arrays.hashCode(getCoaches());
    return result;
  }

  @Override
  public String toString() {
    return "Swimmer{" +
        "name='" + name + '\'' +
        ", discipline=" + discipline +
        ", time=" + time +
        ", clubs=" + Arrays.toString(clubs) +
        ", coaches=" + Arrays.toString(coaches) +
        '}';
  }
}

