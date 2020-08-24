package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecipientTest {
  private Recipient testRecipient;

  @Before
  public void setUp() throws Exception {
    testRecipient = new Recipient("Wen", "Xie", "wx@gmail.com");
  }

  @Test
  public void getFirstName() {
    assertEquals("Wen", testRecipient.getFirstName());
  }

  @Test
  public void setFirstName() {
    testRecipient.setFirstName("Wenwen");
    assertEquals("Wenwen", testRecipient.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Xie", testRecipient.getLastName());
  }

  @Test
  public void setLastName() {
    testRecipient.setLastName("Xie");
    assertEquals("Xie", testRecipient.getLastName());
  }

  @Test
  public void getEmail() {
    assertEquals("wx@gmail.com", testRecipient.getEmail());
  }

  @Test
  public void setEmail() {
    testRecipient.setEmail("wenx@gmail.com");
    assertEquals("wenx@gmail.com", testRecipient.getEmail());
  }

  @Test
  public void testEquals() {
    testRecipient = new Recipient("Wen", "Xie", "wx@gmail.com");
    assertTrue(testRecipient.equals(testRecipient));
    assertFalse(testRecipient.equals("Wen"));
    assertTrue(testRecipient.equals(new Recipient(
        "Wen", "Xie", "wx@gmail.com")));
    assertFalse(testRecipient.equals(new Recipient(
        "Xie", "Xie", "wx@gmail.com")));
    assertFalse(testRecipient.equals(new Recipient(
        "Wen", "Wen", "wx@gmail.com")));
    assertFalse(testRecipient.equals(new Recipient(
        "Wen", "Xie", "ww@gmail.com")));
  }

  @Test
  public void testHashCode(){
    assertEquals(488760893, testRecipient.hashCode());
  }
}