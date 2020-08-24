package problem1.Model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A theater consisting of rows of seats, with specified row wheelchair-accessible
 */
public class Theater {
  private String name;
  private List<Row> listOfRows;
  private List<Integer> wheelChairRows;  // which rows are wheelChairRow, at least one row is wheelChairRow
  private static final int MIN_NUM_OF_WROWS = 1;
  private static final int MIN_NUM_OF_ROWS = 5;
  private static final int MAX_NUM_OF_ROWS = 20;


  /**
   * Constructs a theater with specified name, rows and wheelChairRows
   * @param name name of theater
   * @param listOfRows rows of theater
   * @param wheelChairRows rows that are wheelchair-accessible of the theater
   * @throws IllegalArgumentException when given list of rows or wheelChairRows is out of bound
   */
  public Theater(String name, List<Row> listOfRows, List<Integer> wheelChairRows) throws IllegalArgumentException{
    this.name = name;
    checkListOfRows(listOfRows);
    this.listOfRows = listOfRows;
    checkWheelChairRows(wheelChairRows);
    this.wheelChairRows = wheelChairRows; //[1,2]
    // after all the above validation, set the corresponding rows as wheelChairAccessible
    for (int i : wheelChairRows) {
      listOfRows.get(i - 1).setWheelChairAccess(true);  // input list of Rows start from number 1
    }
  }


  /**
   * validate whether the input listOfRows is legal
   * @param listOfRows rows of theater
   * @return true/false
   * @throws IllegalArgumentException when given list of rows is out of bound
   */
  private boolean checkListOfRows(List<Row> listOfRows) throws IllegalArgumentException{
    if (listOfRows.size() < MIN_NUM_OF_ROWS || listOfRows.size() > MAX_NUM_OF_ROWS) {
      throw new IllegalArgumentException("The theater should have rows between " + MIN_NUM_OF_ROWS +
          " and " + MAX_NUM_OF_ROWS);
    }
    return true;
  }

  /**
   * validate whether the input wheelChairRows is legal
   * @param wheelChairRows a List<Integer> reprsending wheelChairRows of the theater
   * @return true/false
   * @throws IllegalArgumentException when given list of wheelChairRows is out of bound
   */
  private boolean checkWheelChairRows(List<Integer> wheelChairRows) throws IllegalArgumentException{
    if (wheelChairRows.size() < MIN_NUM_OF_WROWS) {
      throw new IllegalArgumentException("should have at least one row of wheel chair accessibility.");
    }
    // wheelChairRows: [1,10]  listOfRows:[Row1, Row2, Row3, Row4, Row5]
    List<Integer> result = wheelChairRows.stream()
        .filter( x-> x < 1 || x > listOfRows.size())
        .collect(Collectors.toList());
    if (result.size() != 0) {
      throw new IllegalArgumentException("row number of wheelChairRows should be between" + MIN_NUM_OF_WROWS + "and "
          + listOfRows.size() + " .");
    }
    return true;
  }

  /**
   * Return listOfRows
   * @return listOfRows
   */
  public List<Row> getListOfRows() {
    return listOfRows;
  }

  /**
   * Return theater name
   * @return theater name
   */
  public String getName() {
    return name;
  }

  /**
   * Check whether two theaters are equal
   * @param o another object to compare with
   * @return true/false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Theater theater = (Theater) o;
    return name.equals(theater.name) &&
        listOfRows.equals(theater.listOfRows) &&
        wheelChairRows.equals(theater.wheelChairRows);
  }


  /**
   * Return the hashcode of the theater
   * @return integer representing the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, listOfRows, wheelChairRows);
  }

  @Override
  public String toString() {
    return "Theater{" +
        "name='" + name + '\'' +
        ", listOfRows=" + listOfRows +
        ", wheelChairRows=" + wheelChairRows +
        '}';
  }
}
