package problem1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Model extends Celebrity {


  public Model(String name, LocalDate dob,
      ArrayList<SocialMed> socialMeds,
      ArrayList<Integer> numOfFollowers, String lastestEvent)
      throws ImpactEstimationException {
    super(name, dob, socialMeds, numOfFollowers, lastestEvent);
  }
}
