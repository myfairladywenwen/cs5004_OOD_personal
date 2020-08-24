package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LunchTest {
  private Lunch testLunch;

  @Before
  public void setUp() {
    testLunch = new Lunch("Wen", 20);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorInvalid1() throws IllegalArgumentException{
    Lunch testLunch1 = new Lunch("Wen", 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorInvalid2() throws IllegalArgumentException{
    Lunch testLunch1 = new Lunch("Wen", 100);
  }
  @Test
  public void getNumOfSandwich() {
    assertEquals(21, (int)(testLunch.getNumOfSandwich()));
  }
}