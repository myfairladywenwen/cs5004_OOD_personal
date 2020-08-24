package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MailItemTest {

  private MailItem testMailItem;
  private Recipient testRecipient = new Recipient("wen", "xie",
      "wx@gmail.com");

  @Before
  public void setUp() throws Exception {
    testMailItem = new MailItem(2,3,4,testRecipient);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorInvalid1() throws IllegalArgumentException{
    testMailItem = new MailItem(0, 3, 4, testRecipient);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorInvalid2() throws IllegalArgumentException{
    testMailItem = new MailItem(1, 0, 4, testRecipient);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructorInvalid3() throws IllegalArgumentException{
    testMailItem = new MailItem(2, 3, 0, testRecipient);
  }

  @Test
  public void getWidth() {
    assertEquals(2, (int)(testMailItem.getWidth()));
  }

  @Test
  public void getHeight() {
    assertEquals(3, (int)(testMailItem.getHeight()));
  }

  @Test
  public void getDepth() {
    assertEquals(4, (int)(testMailItem.getDepth()));
  }

  @Test
  public void getRecipient() {
    assertEquals(testRecipient, testMailItem.getRecipient());
  }
}