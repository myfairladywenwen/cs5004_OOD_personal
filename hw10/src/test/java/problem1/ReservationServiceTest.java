package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import problem1.Controller.ReservationService;
import problem1.Model.Row;
import problem1.Model.Theater;

public class ReservationServiceTest {
  private Theater t1;
  private List<Row> listOfRows = new ArrayList<>();
  private int numOfRows = 5;
  private String theaterName = "AMC";
  private List<Integer> wRows = Arrays.asList(1, 2);


  private Theater t2;
  private List<Row> listOfRows2 = new ArrayList<>();
  private int numOfRows2 = 10;
  private String theaterName2 = "evenAMC";
  private List<Integer> wRows2 = Arrays.asList(1, 2);


  @Before
  public void setUp() throws Exception {
    for (int i = 0; i < numOfRows; i++) {
      listOfRows.add(new Row(i + 1));
    }
    t1 = new Theater(theaterName, listOfRows, wRows);

    for (int i = 0; i < numOfRows2; i++) {
      listOfRows2.add(new Row(i + 1));
    }
    t2 = new Theater(theaterName2, listOfRows2, wRows2);
  }

  @Test
  public void reserveSeatTooMany() {
    boolean result = ReservationService.reserveSeat(t1, 15, "wen", true);
    assertEquals(false, result);
  }

  @Test
  public void reserveSeatNoW() {
    boolean result = ReservationService.reserveSeat(t1, 10, "wen", false);
    assertEquals(true, result);
    //shoule be row3, seatA-E
    for (int i = 0; i < 10; i++) {
      assertEquals("wen", t1.getListOfRows().get(2).get(i).getReservedFor());
    }
  }

  @Test
  public void reserveSeatW() {
    boolean result = ReservationService.reserveSeat(t1, 10, "wen", true);
    assertEquals(true, result);
    //shoule be row2, seatA-E
    for (int i = 0; i < 10; i++) {
      assertEquals("wen", t1.getListOfRows().get(1).get(i).getReservedFor());
    }
  }

  @Test
  public void reserveSeatW2() {
    boolean result = ReservationService.reserveSeat(t1, 10, "wen", true);
    assertEquals(true, result);
    //shoule be row1, seatA-E
    for (int i = 0; i < 10; i++) {
      assertEquals("wen", t1.getListOfRows().get(1).get(i).getReservedFor());
    }
  }

  @Test
  public void reserveSeatNoW2_whenHaveToUseWSeat() {
    List<Row> listOfRows = new ArrayList<>();
    for (int i = 0; i < numOfRows; i++) {
      listOfRows.add(new Row(i + 1));
    }
    t1 = new Theater(theaterName, listOfRows, wRows);

    ReservationService.reserveSeat(t1, 10, "wen", false);
    ReservationService.reserveSeat(t1, 10, "wen", false);
    ReservationService.reserveSeat(t1, 10, "wen", false);
    // now have to use WSeat
    ReservationService.reserveSeat(t1, 10, "wen", false);
    //shoule be row1, seat A-J
    for (int i = 0; i < 10; i++) {
      assertEquals("wen", t1.getListOfRows().get(1).get(i).getReservedFor());
    }
    ReservationService.reserveSeat(t1, 10, "wen", false);
    ReservationService.reserveSeat(t1, 10, "wen", false);
    for (int i = 0; i < 10; i++) {
      assertEquals("wen", t1.getListOfRows().get(1).get(i).getReservedFor());
    }
    // now have no seat
    boolean result = ReservationService.reserveSeat(t1, 10, "wen", false);
    assertEquals(result, false);
  }

  @Test
  public void reserveSeatevenNumRowsTheater1() {
    boolean result = ReservationService.reserveSeat(t2, 5, "wen", false);
    assertEquals(true, result);
    //shoule be row5, seatA-E
    for (int i = 0; i < 5; i++) {
      assertEquals("wen", t2.getListOfRows().get(5).get(i).getReservedFor());
    }
  }

  @Test
  public void reserveSeatEvenNumRowsTheater2() {
    boolean result = ReservationService.reserveSeat(t2, 10, "wen", true);
    assertEquals(true, result);
    //shoule be row1, seatA-J
    for (int i = 0; i < 10; i++) {
      assertEquals("wen", t2.getListOfRows().get(1).get(i).getReservedFor());
    }

    result = ReservationService.reserveSeat(t2, 10, "wen", false);
    assertEquals(true, result);
    //shoule be row5, seatA-J
    for (int i = 0; i < 10; i++) {
      assertEquals("wen", t2.getListOfRows().get(5).get(i).getReservedFor());
    }
    result = ReservationService.reserveSeat(t2, 10, "wen", false);
    assertEquals(true, result);
    //shoule be row4, seatA-J
    for (int i = 0; i < 10; i++) {
      assertEquals("wen", t2.getListOfRows().get(4).get(i).getReservedFor());
    }
    result = ReservationService.reserveSeat(t2, 10, "wen", false);
    assertEquals(true, result);
    //shoule be row6, seatA-J
    for (int i = 0; i < 10; i++) {
      assertEquals("wen", t2.getListOfRows().get(6).get(i).getReservedFor());
    }
  }

}