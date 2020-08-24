package p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TripRecommender {
  private Map<Destination, Integer> destinationStatistics = new HashMap<>();
  private static final int START_VALUE = 1;

  /**
   * Takes as input a list of all Travelers,
   * and converts that list into the destinationStatistics.
   * @param traveler a list of Travelers
   * @return a map with the destination as the key, and the number of Travelers as the value
   */
  public Map<Destination, Integer> getAggregatedStatistics(List<Traveler> traveler){
    for(Traveler t:traveler){
      for (Destination d : t.traveledDestinations()){
        if (destinationStatistics.containsKey(d)){
          destinationStatistics.put(d, destinationStatistics.get(d) + 1);
        } else {
          destinationStatistics.put(d, START_VALUE);
        }
      }
    }
    return destinationStatistics;
  }

  /**
   * return the Destination with most times of visit
   * @return the Destination with most times of visit
   */
  public Destination recommendMostLikelyDestination(){
    List<Entry<Destination, Integer>> listOfEntries = new ArrayList<>(this.destinationStatistics.entrySet());
    Collections.sort(listOfEntries, new Counting());
    Map<Destination, Integer> sortedMap = new HashMap<>();
    for (Entry<Destination, Integer> entry : listOfEntries) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }
    //System.out.println("most favorate: " + listOfEntries.get(listOfEntries.size()-1).getKey());
    return listOfEntries.get(0).getKey();
  }

  /**
   * return the Destination with least times of visit
   * @return the Destination with least times of visit
   */
  public Destination recommendMostUnlikelyDestination(){
    List<Entry<Destination, Integer>> listOfEntries = new ArrayList<>(this.destinationStatistics.entrySet());
    Collections.sort(listOfEntries, new Counting());
    Map<Destination, Integer> sortedMap = new HashMap<>();
    for (Entry<Destination, Integer> entry : listOfEntries) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }
    //System.out.println("least favorate: " + listOfEntries.get(0).getKey());
    return listOfEntries.get(0).getKey();
  }



  /**
   * A comparator that can compare two entries of a map<Destination></Integer> by its value
   */
  public static class Counting implements Comparator<Map.Entry<Destination, Integer>> {
    @Override
    public int compare(Entry<Destination, Integer> e1, Entry<Destination, Integer> e2) {
      return e1.getValue() - e2.getValue();
    }
  }

  public static void main(String[] args){
    Destination d1 = new p3.Destination("place1", "country1", "1", 1000f);
    Destination d2 = new p3.Destination("place2", "country2", "2", 2000f);
    Destination d3 = new p3.Destination("place3", "country3", "3", 3000f);
    Destination d4 = new p3.Destination("place4", "country4", "4", 1000f);
    List<Traveler> travelerList = new ArrayList<>();
    Traveler t1 = new Traveler("a","b", Arrays.asList(d1, d2, d3));
    Traveler t2 = new Traveler("aa","bb", Arrays.asList(d1, d1, d2, d3, d4));
    travelerList.add(t1);
    travelerList.add(t2);

    TripRecommender tripRecommender = new TripRecommender();
    Map<Destination, Integer> resMap = tripRecommender.getAggregatedStatistics(travelerList);
    System.out.println(resMap);

    tripRecommender.recommendMostLikelyDestination();
    tripRecommender.recommendMostUnlikelyDestination();

  }


}
