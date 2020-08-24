package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DinnerTest {
  private Dinner testDinner;

  @Before
  public void setUp() throws Exception {
    testDinner = new Dinner("Wen", 20);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorInvalid1() throws IllegalArgumentException{
    Dinner testDinner1 = new Dinner("Wen", 5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorInvalid2() throws IllegalArgumentException{
    Dinner testDinner1 = new Dinner("Wen", 100);
  }

  @Test
  public void getNumOfNonVeg() {
    assertEquals(16, (int)testDinner.getNumOfNonVeg());
  }

  @Test
  public void getNumOfVeg() {
    assertEquals(4, (int)testDinner.getNumOfVeg());
  }
}