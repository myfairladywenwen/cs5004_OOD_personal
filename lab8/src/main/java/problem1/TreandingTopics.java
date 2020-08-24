package problem1;

import static java.util.stream.Collectors.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreandingTopics {

  public static Map<String, Long> countTopics(List<String> list){
      return list.stream().collect(
          Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public static void main(String[] args){
    List<String> mylist = Arrays.asList("Seattle", "wildfires", "DEFCON26", "NEU", "NEU",
        "Seattle", "Seattle", "NEU", "DEFCON26", "wildfires");
    Map<String, Long> resultMap = countTopics(mylist);
    System.out.println(resultMap);
  }
}
