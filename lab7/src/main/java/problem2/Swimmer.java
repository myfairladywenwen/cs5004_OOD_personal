package problem2;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*Class Swimmer contains information about a swimmer, and the list of their swimming times, when swimming 50m. Four swimming styles are considered: butterfly, backstroke, breaststroke, and freestyle.
 */
public class Swimmer implements Comparable<Swimmer> {
  private String name;
  private List<Double> butterfly50mTimes;
  private List<Double> backstroke50mTimes;
  private List<Double> breaststroke50mTimes;
  private List<Double> freestyle50mTimes;

  public Swimmer(String name, List<Double> butterfly50mTimes, List<Double> backstroke50mTimes, List<Double> breaststroke50mTimes, List<Double> freestyle50mTimes) {
    this.name = name;
    this.butterfly50mTimes = butterfly50mTimes;
    this.backstroke50mTimes = backstroke50mTimes;
    this.breaststroke50mTimes = breaststroke50mTimes;
    this.freestyle50mTimes = freestyle50mTimes;
  }

  public String getName() {
    return name;
  }

  public List<Double> getButterfly50mTimes() {
    return butterfly50mTimes;
  }

  public List<Double> getBackstroke50mTimes() {
    return backstroke50mTimes;
  }

  public List<Double> getBreaststroke50mTimes() {
    return breaststroke50mTimes;
  }

  public List<Double> getFreestyle50mTimes() {
    return freestyle50mTimes;
  }

  @Override
  //YOUR CODE HERE
  // sort in ascending order
  public int compareTo(Swimmer otherSwimmer) {
    if (this.avgFreeStyleTime() - otherSwimmer.avgFreeStyleTime() >= 0){
      return 1;
    }else {
      return -1;
    }
  }

  // helper method to calculate avg FreeStyle time of a swimmer
  public double avgFreeStyleTime(){
    double sum = 0.0;
    for (double time : this.freestyle50mTimes) {
      sum += time;
    }
    return sum/this.freestyle50mTimes.size();
  }
  //toString method
  public String toString(){
    return this.name;
  }

  public static void main(String[] args) {
    List<Double> s1Butterfly = new LinkedList<>();
    s1Butterfly.add(10.0);
    List<Double> s1Freestyle = new LinkedList<>();
    s1Freestyle.add(10.0);
    s1Freestyle.add(11.0);
    s1Freestyle.add(12.0);
    List<Double> s1backstroke = new LinkedList<>();
    s1backstroke.add(10.0);
    List<Double> s1breaststroke = new LinkedList<>();
    s1breaststroke.add(10.0);
    Swimmer s1 = new Swimmer("s1", s1Butterfly, s1backstroke, s1breaststroke, s1Freestyle);

    List<Double> s2Butterfly = new LinkedList<>();
    s2Butterfly.add(10.0);
    List<Double> s2Freestyle = new LinkedList<>();
    s2Freestyle.add(11.0);
    s2Freestyle.add(12.0);
    s2Freestyle.add(13.0);
    List<Double> s2backstroke = new LinkedList<>();
    s2backstroke.add(10.0);
    List<Double> s2breaststroke = new LinkedList<>();
    s2breaststroke.add(10.0);
    Swimmer s2 = new Swimmer("s2", s2Butterfly, s2backstroke, s2breaststroke, s2Freestyle);

    List<Swimmer> swimmers = new LinkedList<>();
    swimmers.add(s1);
    swimmers.add(s2);
    Collections.sort(swimmers);
    System.out.println(swimmers);    // output should be [s1, s2]

  }

}