package problem1;

import java.time.LocalDate;
import java.util.ArrayList;

public class ActingProf extends Artist {

  public ActingProf(String name, LocalDate dob,
      ArrayList<SocialMed> socialMeds,
      ArrayList<Integer> numOfFollowers, ArrayList<String> awards,
      Integer lastSeries, Double grossIncome) throws ImpactEstimationException {
    super(name, dob, socialMeds, numOfFollowers, awards, lastSeries, grossIncome);
  }
}
