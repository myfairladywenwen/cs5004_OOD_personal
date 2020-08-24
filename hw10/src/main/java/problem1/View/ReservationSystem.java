package problem1.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import problem1.Model.Row;
import problem1.Model.Theater;

/**
 * ReservationSystem can interact with user and reserve seats as required
 */
public class ReservationSystem {

  public static void main(String[] args){
    // initialize a theater
    List<Row> listOfRows = new ArrayList<>();
    int numOfRows = 5;
    String theaterName = "AMC";
    for (int i = 0; i < numOfRows; i++) {
      listOfRows.add(new Row(i + 1));
    }
    List<Integer> wRows = Arrays.asList(2, 5);
    Theater t = new Theater(theaterName, listOfRows, wRows);

    Interactor interactor = new Interactor(t);
    /*
    // interact with user
    Boolean done = false;
    Scanner s = new Scanner(System.in);
    while (!done){
      System.out.println("What would you like to do?");
      String content = s.nextLine();
      switch (content){
        case "show":
          Display.displayTheater(t);
          break;
        case "done":
          done = true;
          break;
        default:  //reserve3
          Pattern p = Pattern.compile("\\d+");
          Matcher matcher = p.matcher(content);
          if (!matcher.find()) { // no number in user input
            System.out.println("Please contain the number of seats you want to reserve.");
          } else {
            int countReserve = Integer.parseInt(matcher.group());
            System.out.println("What is your name?");
            String name = s.nextLine();
            System.out.println("Do you need wheelchair access? Please enter yes or no.");
            String wheelchairAccess = s.nextLine();
            Boolean needWAccess;
            if (wheelchairAccess.equals("yes")){
              needWAccess = true;
            }else{
              needWAccess = false;
            }

            boolean result = ReservationService.reserveSeat(t, countReserve, name, needWAccess);
            if (result) {
              System.out.println(
                  "I have reserved " + countReserve + " seats at " + theaterName + ", " + name);
            }else {
              System.out.println(
                  "Sorry, we do not have that many seats for you at " + theaterName + ", " + name);
            }
            break;
          }
      }
    }
    System.out.println("Have a nice day!");
    */
    interactor.interact();
  }

}
