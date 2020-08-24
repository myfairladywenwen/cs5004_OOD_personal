package problem1;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
  public static List<String> writePhoneNum(List<String> infoBook){
    List<String> newInfoBook = new LinkedList<>();
    for(String info: infoBook){
      String newInfo = process(info);
      newInfoBook.add(newInfo);
    }
    return newInfoBook;
  }

  public static String process(String oldInfo) {
    String[] infoArr = oldInfo.split(":");
    String numToModify = infoArr[2];
    String newNum = numToModify.replaceAll("\\(", "")
        .replaceAll("-", ".").replaceAll("\\)", ".")
        .replaceAll(",", ".");
    infoArr[2] = newNum;
    String newInfo = String.join(": ", infoArr);
    return newInfo;
  }

  public static void main(String[] args){
     List<String> info = new LinkedList<>();
     info.add("Bill Gates:1 Infinite Loop:(425)524-1234:Redmond");
     info.add("Bonnie Dunbar:Museum of Flight:206.764.5720:Seattle");
     info.add("Ichiro:Seattle Mariners:206-346-4000:Seattle");
     List<String> newInfo = writePhoneNum(info);
     for(String line: newInfo){
       System.out.println(line);
     }
  }
}
