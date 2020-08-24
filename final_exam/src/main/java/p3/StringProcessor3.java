package p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringProcessor3 {
    private List<String> someString = new ArrayList<>();

  /**
   * Returns a map with the given List</String> as the key,
   * and the number of times the chosen digits occurs as the value
   * @param list a given List</String>
   * @param digit1 first target char
   * @param digit2 second target char
   * @return a map
   */
    public static Map<String, Integer> countChosenDigit(List<String> list, char digit1, char digit2)
    {
      //YOUR CODE HERE
      Map<String, Integer> resMap = new HashMap<>();
      int count;
      for (String s: list){
        count = StringProcessor3.countOccurrence(s, digit1);
        count += StringProcessor3.countOccurrence(s, digit2);
        resMap.put(s, count);
      }
      return resMap;
    }

  /**
   * A helper method that counts the occurrence of the number of times the chosen digits occurs in the given string
   * @param s given string
   * @param digit target char
   * @return an int
   */
    private static int countOccurrence(String s, char digit){
      int result = 0;
      for(int idx = 0; idx < s.length(); idx++){
        if (s.charAt(idx) == digit){
          result++;
        }
      }
      return result;
    }


    public static void main(String[] args){
      List<String> mylist = Arrays.asList("Seattle55", "Seahawks12345", "Space Needle");
      System.out.println(StringProcessor3.countChosenDigit(mylist, '5', '2'));
    }

  }
