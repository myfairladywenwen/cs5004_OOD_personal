package problem1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FCountDemo {

  public static Map<Integer, Double> countFrequency(List<Integer> list) {
    Map<Integer, Double> fCount = new HashMap<>();
    for (Integer item : list) {
      if (fCount.containsKey(item)){
        fCount.put(item, fCount.get(item) + 1.0);
      } else {
        fCount.put(item, 1.0);
      }
    }
    int total = list.size();
    for (Integer key : fCount.keySet()){
      fCount.put(key, fCount.get(key)/total);
    }
      return fCount;
  }


  public static void main(String[] args){
    List<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(1);
    list.add(1);
    list.add(2);
    list.add(2);
    list.add(3);
    list.add(3);
    list.add(4);
    list.add(4);
    list.add(4);
    Map<Integer, Double> result = countFrequency(list);
    System.out.println(result);
  }
}
