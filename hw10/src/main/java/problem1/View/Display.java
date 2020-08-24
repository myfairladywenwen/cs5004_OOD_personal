package problem1.View;

import java.util.List;
import problem1.Model.Row;
import problem1.Model.Seat;
import problem1.Model.Theater;

/**
 * Display is a class which can display the seat of rows in a theater
 */
public class Display {

  /**
   * Display the all the seats of the theater
   * @param t theater to display
   */
  public static void displayTheater(Theater t) {
    List<Row> list = t.getListOfRows();
    for (Row r : list){
      displayRow(r);
    }
  }

  /**
   * Display seats of the row
   * @param r row to display
   */
  private static void displayRow(Row r){
    System.out.print(r.getRowNo() + " ");
    String symbol;
    if (r.getWheelChairAccess()){
      symbol = "=";
    } else {
      symbol = "_";
    }
    for(Seat s: r){
      displaySeat(s, symbol);
    }
    System.out.println();
  }

  /**
   * Display the seat, using given symbol
   * @param s seat to display
   * @param symbol representing the seat
   */
  private static void displaySeat(Seat s, String symbol){
    if (s.getReservedFor() != null) {
      System.out.print(" X ");
    } else {
      System.out.print(" " + symbol + " ");
    }
  }

  // class consists of all static methods, no need for equals(), hashcode(), toString()
}
