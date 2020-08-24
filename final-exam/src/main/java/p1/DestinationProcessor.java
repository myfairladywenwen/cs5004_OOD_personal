package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function; import java.util.stream.Collectors;

public class DestinationProcessor {
  private List<Destination> destinations = new ArrayList<>();

  public DestinationProcessor(List<Destination> destinations){this.destinations = destinations;}

  public DestinationProcessor(Destination destination1, Destination destination2){
    this.destinations.add(destination1);
    this.destinations.add(destination2);
  }

  /**
   * Count the number of destinations in the given List</Destination>, put them in a map,
   * with the destination as the key, and the count of that destination as the value
   * @param destinations a list of Destinations
   * @return the map with the destination as the key, and the count of that destination as the value
   */
  public static Map<Destination, Long> countDestinations(List<Destination> destinations) {
    return destinations.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public List<Item> filterByDistance(Float distance){
    //YOUR CODE HERE
    return null;
  }
}
