package problem1;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
  public static List<String> writePhoneNum2(List<String> infoBook){
    List<String> newInfoBook = new LinkedList<>();
    for(String info: infoBook){
      String newInfo = process2(info);
      newInfoBook.add(newInfo);
    }
    return newInfoBook;
  }

  public static String process2(String oldInfo) {
    Pattern p = Pattern.compile("\\((\\d{3})\\)(\\d{3})\\-(\\d{4})|(\\d{3})\\-(\\d{3})\\-(\\d{4})");
    // group 0 : whole phoneNum String
    // group1 2 3 4 5 6: three digits
    Matcher m = p.matcher(oldInfo);
    String result;
    if (m.find()) {
      if (m.group(1) == null) { // not (123)456-7890 version, i.e., 123-456-7890
        result = m.replaceAll(m.group(4) + "." + m.group(5) + "." + m.group(6));
        return result;
      } else {  // (123)-456-7890 version
        result = m.replaceAll(m.group(1) + "." + m.group(2) + "." + m.group(3));
        return result;
      }
    }else{
      return oldInfo;
    }
  }

  public static void main(String[] args){
    List<String> info = new LinkedList<>();
    info.add("Bill Gates:1 Infinite Loop:(425)524-1234:Redmond");
    info.add("Bonnie Dunbar:Museum of Flight:206.764.5720:Seattle");
    info.add("Ichiro:Seattle Mariners:206-346-4000:Seattle");
    List<String> newInfo = writePhoneNum2(info);
    for(String line: newInfo){
      System.out.println(line);
    }
  }


}
