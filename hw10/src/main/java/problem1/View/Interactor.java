package problem1.View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import problem1.Controller.ReservationService;
import problem1.Model.Theater;

/**
 * Interactor takes charge of interact with user in terminal
 */
public class Interactor {
  private Theater t;

  public Interactor(Theater t) {
    this.t = t;
  }

  public void interact(){
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
                  "I have reserved " + countReserve + " seats at " + t.getName() + ", " + name);
            }else {
              System.out.println(
                  "Sorry, we do not have that many seats for you at " + t.getName() + ", " + name);
            }
            break;
          }
      }
    }
    System.out.println("Have a nice day!");
    s.close();
  }

}
