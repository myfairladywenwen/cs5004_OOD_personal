package problem1;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import problem1.Model.Row;
import problem1.Model.Theater;
import problem1.View.Interactor;

public class InteractorTest {

  private Theater t1;
  private List<Row> listOfRows1 = new ArrayList<>();
  private int numOfRows = 5;
  private String theaterName1 = "AMC";
  private List<Integer> wRows1 = Arrays.asList(1, 2);

  private Interactor interactor;
  private ByteArrayInputStream inputStream;
  private ByteArrayOutputStream outStream;


  @Before
  public void setUp() throws Exception {
    for (int i = 0; i < numOfRows; i++) {
      listOfRows1.add(new Row(i + 1));
    }
    t1 = new Theater(theaterName1, listOfRows1, wRows1);
    interactor = new Interactor(t1);
    this.outStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outStream));
  }

  @After
  public void tearDown() throws Exception {
    System.setIn(System.in);
    System.setOut(System.out);
  }

  @Test
  public void testInteractReserve3() {
    //inputStream = new ByteArrayInputStream(("reserve3" + System.lineSeparator()+
        //"wen" + System.lineSeparator()+
        //"no" + System.lineSeparator()).getBytes());
    //System.setIn(inputStream);
    //outStream.reset();
    //interactor.interact();
    //String expectOutput = "What would you like to do?" + System.lineSeparator()+ "What is your name?" + System.lineSeparator()
        //+ "Do you need wheelchair access? Please enter yes or no."
        //+ System.lineSeparator();
    //assertEquals(expectOutput, outStream.toString());
    //inputStream = new ByteArrayInputStream(("reserve3" + System.lineSeparator()).getBytes());
//    System.setIn(inputStream);
//    outStream.reset();
   //interactor.interact();
    //expectOutput = "What would you like to do?" + System.lineSeparator();
    //assertEquals(expectOutput, outStream.toString());


  }
}