package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScheduleTest {

  private Schedule testSchedule;

  @Before
  public void setUp() throws Exception {
    testSchedule = new Schedule();
  }

  @Test
  public void getLunch() throws EventAlreadyBookedException {
    Lunch testLunch = new Lunch ("Wen", 30);
    testSchedule.bookLunch(testLunch);
    assertEquals(testLunch, testSchedule.getLunch());
  }

  @Test
  public void getDinner() throws EventAlreadyBookedException {
    Dinner testDinner = new Dinner("Wen", 30);
    testSchedule.bookDinner(testDinner);
    assertEquals(testDinner, testSchedule.getDinner());
  }

  @Test
  public void lunchIsBooked() throws EventAlreadyBookedException {
    assertFalse(testSchedule.lunchIsBooked());
    testSchedule.bookLunch(new Lunch("Wen", 30));
    assertTrue(testSchedule.lunchIsBooked());
  }

  @Test
  public void dinnerIsBooked() throws EventAlreadyBookedException {
    assertFalse(testSchedule.dinnerIsBooked());
    testSchedule.bookDinner(new Dinner("Wen", 30));
    assertTrue(testSchedule.dinnerIsBooked());
  }

  @Test
  public void testBookLunch() throws EventAlreadyBookedException {
    Lunch testLunch = new Lunch("Wen", 30);
    testSchedule.bookLunch(testLunch);
    assertTrue(testSchedule.lunchIsBooked());
    assertEquals(testLunch, testSchedule.getLunch());
  }

  @Test(expected = EventAlreadyBookedException.class)
  public void bookLunchInvalid() throws EventAlreadyBookedException {
    testSchedule.bookLunch(new Lunch("Wen", 30));
    testSchedule.bookLunch(new Lunch("Wen", 30));
  }

  @Test
  public void bookDinner() throws EventAlreadyBookedException {
    Dinner testDinner = new Dinner("Wen", 30);
    testSchedule.bookDinner(testDinner);
    assertTrue(testSchedule.dinnerIsBooked());
    assertEquals(testDinner, testSchedule.getDinner());
  }

  @Test(expected = EventAlreadyBookedException.class)
  public void bookDinnerInvalid() throws EventAlreadyBookedException {
    testSchedule.bookDinner(new Dinner("Wen", 30));
    testSchedule.bookDinner(new Dinner("Wen", 30));
  }
}