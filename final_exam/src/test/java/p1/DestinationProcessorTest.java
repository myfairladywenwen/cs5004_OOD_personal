package p1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class DestinationProcessorTest {

  private DestinationProcessor destinationProcessor;
  private List<Destination> destinations = new ArrayList<>();
  private Destination d1;
  private Destination d2;
  private Destination d3;
  private Destination d4;

  @Before
  public void setUp() throws Exception {
    d1 = new Destination("place1", "country1", "1", 1000f);
    d2 = new Destination("place2", "country2", "2", 2000f);
    d3 = new Destination("place3", "country3", "3", 3000f);
    d4 = new Destination("place1", "country1", "1", 1000f);
    destinations.add(d1);
    destinations.add(d2);
    destinations.add(d3);
    destinations.add(d4);
  }

  // d1->2
  // d2->1
  // d3->1
  @Test
  public void testCountDestinations() {
    Map<Destination, Long> resMap = DestinationProcessor.countDestinations(destinations);
    assertEquals(2, resMap.get(d1).intValue());
    assertEquals(1, resMap.get(d2).intValue());
    assertEquals(1, resMap.get(d3).intValue());
  }

  //test empty
  @Test
  public void testCountDestinationsEmpty() {
    destinations = new ArrayList<>();
    Map<Destination, Long> resMap = DestinationProcessor.countDestinations(destinations);
    assertEquals(0, resMap.size());
  }

  @Test
  public void testFilterByDistance() {
    DestinationProcessor destinationProcessor = new DestinationProcessor(destinations);
    List<Destination> resList = destinationProcessor.filterByDistance(1500f);
    assertEquals(2, resList.size());
    assertTrue(resList.contains(d1));
    assertTrue(resList.contains(d4));
    assertFalse(resList.contains(d2));
    assertFalse(resList.contains(d3));
  }

  // test empty
  @Test
  public void testFilterByDistanceEmpty() {
    destinations = new ArrayList<>();
    DestinationProcessor destinationProcessor = new DestinationProcessor(destinations);
    List<Destination> resList = destinationProcessor.filterByDistance(1500f);
    assertEquals(0, resList.size());
  }

}