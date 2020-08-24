package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import problem1.Model.Row;
import problem1.Model.Theater;

public class TheaterTest {

  private Theater t1;
  private List<Row> listOfRows1 = new ArrayList<>();
  private int numOfRows = 5;
  private String theaterName1 = "AMC";
  private List<Integer> wRows1 = Arrays.asList(1, 2);

  private Theater t2;
  private List<Row> listOfRows2 = new ArrayList<>();
  private int numOfRows2 = 5;
  private String theaterName2 = "AMC";
  private List<Integer> wRows2 = Arrays.asList(1, 2);

  private Theater t3;
  private List<Row> listOfRows3 = new ArrayList<>();
  private int numOfRows3 = 15;
  private String theaterName3 = "AMC";
  private List<Integer> wRows3 = Arrays.asList(1, 2);

  @Before
  public void setUp() throws Exception {
    for (int i = 0; i < numOfRows; i++) {
     listOfRows1.add(new Row(i + 1));
    }
    t1 = new Theater(theaterName1, listOfRows1, wRows1);
    for (int i = 0; i < numOfRows2; i++) {
      listOfRows2.add(new Row(i + 1));
    }
    t2 = new Theater(theaterName2, listOfRows2, wRows2);
    for (int i = 0; i < numOfRows3; i++) {
      listOfRows3.add(new Row(i + 1));
    }
    t3 = new Theater(theaterName3, listOfRows3, wRows3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCheckListOfRows1()throws IllegalArgumentException{
    listOfRows3 = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      listOfRows3.add(new Row(i + 1));
    }
    t3 = new Theater(theaterName3, listOfRows3, wRows3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCheckListOfRows2()throws IllegalArgumentException{
    listOfRows3 = new ArrayList<>();
    for (int i = 0; i < 30; i++) {
      listOfRows3.add(new Row(i + 1));
    }
    t3 = new Theater(theaterName3, listOfRows3, wRows3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCheckWheelChairRows1()throws IllegalArgumentException{
    wRows3 = Arrays.asList();
    t3 = new Theater(theaterName3, listOfRows3, wRows3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCheckWheelChairRows2()throws IllegalArgumentException{
    wRows3 = Arrays.asList(20);
    t3 = new Theater(theaterName3, listOfRows3, wRows3);
  }

  @Test
  public void testGetName(){
    assertEquals(theaterName1, t1.getName());
  }

  @Test
  public void testEquals1() {
    assertTrue(t1.equals(t1));
    assertTrue(t1.equals(t2));
  }

  @Test
  public void testEquals2() {
    assertFalse(t1.equals(null));
  }

  @Test
  public void testEquals3() {
    assertFalse(t1.equals(123));
  }

  @Test
  public void testEquals4() {
    assertFalse(t1.equals(t3));
  }


  @Test
  public void testHashCode1() {
    assertEquals(t1.hashCode(), t2.hashCode());
  }

  @Test
  public void testHashCode2() {
    assertNotEquals(t1.hashCode(), t3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Theater{name='AMC', "
        + "listOfRows=["
        + "Row{rowNo=1, wheelChairAccess=true, seatsPerRow=10}, "
        + "Row{rowNo=2, wheelChairAccess=true, seatsPerRow=10}, "
        + "Row{rowNo=3, wheelChairAccess=false, seatsPerRow=10}, "
        + "Row{rowNo=4, wheelChairAccess=false, seatsPerRow=10}, "
        + "Row{rowNo=5, wheelChairAccess=false, seatsPerRow=10}], "
        + "wheelChairRows=[1, 2]}", t1.toString());
  }
}