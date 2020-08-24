package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import problem1.Model.Row;
import problem1.Model.Theater;

public class DisplayTest {
  Theater t1;
  List<Row> listOfRows1 = new ArrayList<>();
  int numOfRows = 5;
  String theaterName1 = "AMC";
  List<Integer> wRows1 = Arrays.asList(1, 2);

  @Before
  public void setUp() throws Exception {
    for (int i = 0; i < numOfRows; i++) {
      listOfRows1.add(new Row(i + 1));
    }
    t1 = new Theater(theaterName1, listOfRows1, wRows1);
  }

  @Test
  public void displayTheater() {
  }
}