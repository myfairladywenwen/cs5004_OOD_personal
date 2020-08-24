package problem1.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import problem1.Model.Row;
import problem1.Model.Seat;
import problem1.Model.Theater;

/**
 * ReservationService is a class has the method to reserve seats
 */
public class ReservationService {

  /**
   * reserve seats with given requirements
   * @param t the theater
   * @param count how many seats to reserve
   * @param name reserve seats for whom
   * @param needWAccess true/false
   * @return true/false
   */
  public static boolean reserveSeat(Theater t, int count, String name, boolean needWAccess) {
    int seatsPerRow = t.getListOfRows().get(0).getSeatsPerRow();
    if (count > seatsPerRow) {
      return false;
    }
    if (needWAccess) {
      Map<Integer, List<String>> rowFound= findOptimalWAccess(t, count); //  {3: [A,B,C]}
      if (rowFound.isEmpty()){
        return false;
      }
      setSeatsAsReserved(rowFound, t, count, name);
      return true;
    } else { // do not need wAccess
      // first, find from noWAccess rows
      Map<Integer, List<String>> rowFound= findOptimalNoWAccess(t, count); //  {3: [A,B,C]}
      if (rowFound.isEmpty()){
        // if noWAccess Rows are all occupied, find from WAccess Rows
        rowFound = findOptimalWAccess(t, count);
      }
      if (rowFound.isEmpty()){
        return false;
      }
      setSeatsAsReserved(rowFound, t, count, name);
      return true;
    }
  }

  /**
   * find the best seats(no need of wheelchair access) available and return it in a map
   * @param t the theater
   * @param count how many seats to reserve
   * @return a map, with rowNo as the key, list</String> as the value to represent the seats reserved
   */
  private static Map<Integer, List<String>> findOptimalNoWAccess(Theater t, int count) {
    Map<Integer, List<String>> rowFound = new HashMap<>();
    int startline = t.getListOfRows().size() / 2;
    boolean found = false;
    int lineAccum = 0;
    while (!found && startline >= 0 && startline <= t.getListOfRows().size() - 1) {
      if (t.getListOfRows().get(startline).getWheelChairAccess()){
        lineAccum++;
        if(lineAccum%2 == 0) {
          startline += lineAccum;
        }else{
          startline -= lineAccum;
        }
        continue;
      }
      List<Seat> seatsAvail = t.getListOfRows().get(startline).stream()
          .filter(x -> x.getReservedFor() == null)
          .collect(Collectors.toList());
        // check empty seats count
      if (seatsAvail.size() >= count) {
        // check whether the list's element is continuously -- no need to check
          found = true;
          rowFound.put(startline, seatsAvail.stream().map(Seat::getSeatName)
                .collect(Collectors.toList()));
          return rowFound;
      }
      lineAccum++;
      if(lineAccum%2 == 0) {
        startline += lineAccum;
      }else{
        startline -= lineAccum;
      }
    }
    return rowFound;
  }

  /**
   * find the best seats(need wheelchair access) available and return it in a map
   * @param t the theater
   * @param count how many seats to reserve
   * @return a map, with rowNo as the key, list</String> as the value to represent the seats reserved
   */
  private static Map<Integer, List<String>> findOptimalWAccess(Theater t, int count) {
    Map<Integer, List<String>> rowFound = new HashMap<>();
    int startline = t.getListOfRows().size() / 2;
    boolean found = false;
    int lineAccum = 0;
    while (!found && startline >= 0 && startline <= t.getListOfRows().size() - 1) {
      //check it is wRow
      if (t.getListOfRows().get(startline).getWheelChairAccess()) {
        List<Seat> seatsAvail = t.getListOfRows().get(startline).stream()
            .filter(x -> x.getReservedFor() == null)
            .collect(Collectors.toList());
        // check empty seats count
        if (seatsAvail.size() >= count) {
          // check whether the list's element is continuously  -- no need to check
            found = true;
            rowFound.put(startline, seatsAvail.stream().map(Seat::getSeatName)
                .collect(Collectors.toList()));
            return rowFound;
        }
      }
      lineAccum++;
      if(lineAccum%2 == 0) {
        startline += lineAccum;
      }else{
        startline -= lineAccum;
      }
    }
    return rowFound;
  }

  /**
   * set the seats in particular row as reserved for the user
   * @param rowFound the row to modify
   * @param t the theatre
   * @param count how many seats to be reserved
   * @param name reserve seat for whom
   */
  private static void setSeatsAsReserved(Map<Integer, List<String>> rowFound, Theater t, int count,
      String name) {
    for (int key : rowFound.keySet()) {
      Row rowToModify = t.getListOfRows().get(key);
      for (int j = 0; j < rowToModify.size(); j++) {
        if (rowToModify.get(j).getSeatName().equals(rowFound.get(key).get(0))) { //find first seat
          for (int k = 0; k < count; k++) {
            rowToModify.set(j + k, new Seat(rowFound.get(key).get(k), name));
          }
          break;
        }
      }
    }
  }

  // class consists of all static methods, no need for equals(), hashcode(), toString()
}
