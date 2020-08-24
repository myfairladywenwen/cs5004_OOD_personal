package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function; import java.util.stream.Collectors;

public class TravelerProcessor {
  private List<Traveler> travelers = new ArrayList<>();

  public TravelerProcessor(List<Traveler> travelers){this.travelers = travelers;}

  public TravelerProcessor(Traveler traveler1, Traveler traveler2){
    this.travelers.add(traveler1);
    this.travelers.add(traveler2);
  }

  public static Map<Traveler, Long> countTravelers(List<Traveler> travelers) {
    return travelers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public List<Traveler> filterByNumTrips(Integer numTrips){
    //YOUR CODE HERE
    return null;
  }
}
