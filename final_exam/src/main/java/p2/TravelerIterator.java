package p2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * An iterator that iterates over the given list of Travelers,
 * and returns those travelers who traveled to countries "Austria", "Germany" and "Switzerland"
 * during the last year.
 */
public class TravelerIterator implements Iterator<Traveler> {

  private List<Traveler> travelers = new ArrayList<>();
  int pos;
  public static final String AUS = "Austria";
  public static final String GERMANY = "Germany";
  public static final String SWIZ = "Switzerland";


  // helper method to get those qualified travelers
  private List<Traveler> filter(){
    List<Traveler> filterResult = this.travelers.stream().
        filter(t->t.traveledDestinations().contains(AUS))
        .filter(t->t.traveledDestinations().contains(GERMANY))
        .filter(t->t.traveledDestinations().contains(SWIZ))
        .collect(Collectors.toList());
    return filterResult;
  }

  /**
   * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true}
   * if {@link #next} would return an element rather than throwing an exception.)
   *
   * @return {@code true} if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    return pos < this.filter().size();
  }


  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Traveler next() throws NoSuchElementException{
    if (hasNext()){
      Traveler toReturn = this.filter().get(pos);
      pos++;
      return toReturn;
    }
    throw new NoSuchElementException("do not have a qualified traveller");
  }
}
