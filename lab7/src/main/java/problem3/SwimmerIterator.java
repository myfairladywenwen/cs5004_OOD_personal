package problem3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import problem2.Swimmer;

public class SwimmerIterator implements Iterator<Swimmer> {
  public static final int BUTTERFLY_TIMES = 5;
  public static final double FREESTYLE_QUALIFY = 26.17;

  private List<Swimmer> runners = new ArrayList<>();
  private int pos = 0;

  // helper method to get those qualified swimmers
  private List<Swimmer> filer(){
    List<Swimmer> filterResult = new ArrayList<>();
    for (Swimmer s : this.runners){
      if (butterflyQualify(s) && freestyleQualify(s)){
        filterResult.add(s);
      }
    }
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
    return pos < this.filer().size();
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Swimmer next() {
    if (hasNext()){
      Swimmer toReturn = this.filer().get(pos);
      pos++;
      return toReturn;
    }
    throw new NoSuchElementException("do not have a qualified swimmer");
  }

  // helper method
  public boolean butterflyQualify(Swimmer s){
    return s.getButterfly50mTimes().size() >= BUTTERFLY_TIMES;
  }
  // helper method
  public boolean freestyleQualify(Swimmer s){
    for (double time : s.getFreestyle50mTimes()) {
      if (time <= FREESTYLE_QUALIFY){
        return true;
      }
    }
    return false;
  }

}
