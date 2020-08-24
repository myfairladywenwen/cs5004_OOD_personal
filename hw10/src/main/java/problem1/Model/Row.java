package problem1.Model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Row is a row of Seats
 */
public class Row extends ArrayList<Seat> {
  private int rowNo;  // 1, ++
  private boolean wheelChairAccess;  // default is false
  private int seatsPerRow;
  private static final int DEFAULT_SEATS_PER_ROW = 10;
  private static final int MIN_SEATS_PER_ROW = 10;
  private static final int MAX_SEATS_PER_ROW = 26;
  private static final int MAX_NUM_OF_ROWS = 20;
  private static final int START_ROW = 1;


  /**
   * Constructs a Row with given rowNo, and default other fields
   * @param rowNo an int
   * @throws IllegalArgumentException when input rowNo is out of bound
   */
  public Row(int rowNo) throws IllegalArgumentException{
    checkRowNo(rowNo);
    this.rowNo = rowNo;
    this.wheelChairAccess = false;
    this.seatsPerRow = DEFAULT_SEATS_PER_ROW;
    this.addSeatToRow(this.seatsPerRow);
  }

  /**
   * add given number of Seats to the row
   * @param seatsPerRow how many seats in a row
   */
  private void addSeatToRow(int seatsPerRow){
    for (int i = 0; i < seatsPerRow; i++) {
      this.add(new Seat(Character.toString((char) ('A' + i))));
      //System.out.print(this.get(i).getSeatName());
    }
  }

  /**
   * Constructs an empty row of seats with specified rowNo, seatsPerRow and wheelChairAccess.
   * @param rowNo rowNo
   * @param seatsPerRow  how many seats in a row
   * @param wheelChairAccess true or false
   * @throws IllegalArgumentException when given RowNo or SeatsPerRow is out of bound
   */
  public Row(int rowNo, int seatsPerRow, boolean wheelChairAccess) throws IllegalArgumentException{
    checkRowNo(rowNo);
    this.rowNo = rowNo;
    checkSeatsPerRow(seatsPerRow);
    this.seatsPerRow = seatsPerRow;
    this.addSeatToRow(seatsPerRow);
    this.wheelChairAccess = wheelChairAccess;
  }

  /**
   * set the row as wheelChairAccess
   * @param wheelChairAccess true of false
   */
  public void setWheelChairAccess(boolean wheelChairAccess) {
    this.wheelChairAccess = wheelChairAccess;
  }

  /**
   * validate rowNo
   * @param rowNo an int
   * @return true/false
   * @throws IllegalArgumentException when out of bound
   */
  private boolean checkRowNo(int rowNo) throws IllegalArgumentException {
    if (rowNo < START_ROW || rowNo - 1 > MAX_NUM_OF_ROWS) {
      throw new IllegalArgumentException("row number should be between " + START_ROW + " and " + MAX_NUM_OF_ROWS + " .");
    }
    return true;
  }

  /**
   * validate seatsPerRow
   * @param seatsPerRow an int of seatsPerRow
   * @return true/false
   * @throws IllegalArgumentException when out of bound
   */
  private boolean checkSeatsPerRow(int seatsPerRow) throws IllegalArgumentException {
    if (seatsPerRow < MIN_SEATS_PER_ROW || seatsPerRow  > MAX_SEATS_PER_ROW) {
      throw new IllegalArgumentException("row number should be between " + MIN_SEATS_PER_ROW
          + " and " + MAX_SEATS_PER_ROW + " .");
    }
    return true;
  }

  /**
   * Return wheelChairAccess
   * @return true/false
   */
  public boolean getWheelChairAccess() {
    return wheelChairAccess;
  }

  /**
   * Return rowNo
   * @return an int
   */
  public int getRowNo() {
    return rowNo;
  }

  /**
   * Return seatsPerRow
   * @return an int
   */
  public int getSeatsPerRow() {
    return seatsPerRow;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Row row = (Row) o;
    return rowNo == row.rowNo &&
        wheelChairAccess == row.wheelChairAccess &&
        seatsPerRow == row.seatsPerRow;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), rowNo, wheelChairAccess, seatsPerRow);
  }

  @Override
  public String toString() {
    return "Row{" +
        "rowNo=" + rowNo +
        ", wheelChairAccess=" + wheelChairAccess +
        ", seatsPerRow=" + seatsPerRow +
        '}';
  }
}
