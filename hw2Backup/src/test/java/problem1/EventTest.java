package problem1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class EventTest {
  private Event testEvent;
  private String testClientName = "Wen";
  private Integer testNumOfPeople = 10;

  @Before
  public void setUp() {
    testEvent = new Event(testClientName, testNumOfPeople);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorInvalid() throws IllegalArgumentException{
    Event testEvent1 = new Event(testClientName, -testNumOfPeople);
  }

  @Test
  public void getClientName() {
    assertEquals(testClientName, testEvent.clientName);
  }

  @Test
  public void setClientName() {
    testEvent.setClientName(testClientName+testClientName);
    assertEquals(testClientName + testClientName, testEvent.getClientName());
  }

  @Test
  public void getNumOfPeople() {
    assertEquals(testNumOfPeople, testEvent.numOfPeople);
  }

  @Test
  public void setNumOfPeople() {
    testEvent.setNumOfPeople(20);
    assertEquals(20, (int)testEvent.getNumOfPeople());
  }

//  @Test
//  public void equals(){
//    Event testEvent2 = new Event("Wen", 10);
//    Event testEvent3 = new Event("Wen", 20);
//    Event testEvent4 = new Event("Wenwen", 10);
//    Event testEvent5 = new Event("Wenwen", 20);
//    assertTrue(testEvent.equals(testEvent));
//    assertFalse(testEvent.equals("Wen"));
//    assertTrue(testEvent.equals(testEvent2));
//    assertFalse(testEvent.equals(testEvent3));
//    assertFalse(testEvent.equals(testEvent4));
//    assertFalse(testEvent.equals(testEvent5));
//  }

//  @Test
//  public void testHashCode(){
//    assertEquals(2693259,testEvent.hashCode());
//  }
//
}
