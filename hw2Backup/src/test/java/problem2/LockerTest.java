package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LockerTest {
  private Locker testLocker;
  private Recipient testRecipient;
  private MailItem testMailItem;

  @Before
  public void setUp() throws Exception {
    testLocker = new Locker(2,3,4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ConstructorInvalid1() throws IllegalArgumentException{
    testLocker = new Locker(0, 3, 4);
  }
  @Test(expected = IllegalArgumentException.class)
  public void ConstructorInvalid2() throws IllegalArgumentException{
    testLocker = new Locker(2, 0, 4);
  }
  @Test(expected = IllegalArgumentException.class)
  public void ConstructorInvalid3() throws IllegalArgumentException{
    testLocker = new Locker(2, 3, 0);
  }
  @Test(expected = IllegalArgumentException.class)
  public void ConstructorInvalid4() throws IllegalArgumentException{
    testLocker = new Locker(0, 0, 0);
  }

  @Test
  public void getMaxWidth() {
    assertEquals(2, (int)testLocker.getMaxWidth());
  }

  @Test
  public void getMaxHeight() {
    assertEquals(3, (int)testLocker.getMaxHeight());
  }

  @Test
  public void getMaxDepth() {
    assertEquals(4, (int)testLocker.getMaxDepth());
  }

  @Test
  public void getMailItem() throws LockerOccupiedException, ExceedLockerSizeException{
    testRecipient = new Recipient("wen", "xie", "wx@gmail.com");
    testMailItem = new MailItem(1,2,3, testRecipient);
    testLocker.addMail(testMailItem);
    assertEquals(testMailItem, testLocker.getMailItem());
  }

  @Test
  public void addMail() throws LockerOccupiedException, ExceedLockerSizeException{
    testRecipient = new Recipient("wen", "xie", "wx@gmail.com");
    testMailItem = new MailItem(1,2,3, testRecipient);
    testLocker.addMail(testMailItem);
    assertTrue(testLocker.getMailItem() != null);
    assertEquals(testMailItem, testLocker.getMailItem());
  }

  @Test(expected = LockerOccupiedException.class)
  public void addMailInvalid1() throws LockerOccupiedException, ExceedLockerSizeException {
    testRecipient = new Recipient("wen", "xie", "wx@gmail.com");
    MailItem testMailItem1 = new MailItem(1, 2, 3, testRecipient);
    testLocker.addMail(testMailItem1);
    MailItem testMailItem2 = new MailItem(1, 2, 3, testRecipient);
    testLocker.addMail(testMailItem2);
  }

  @Test(expected = ExceedLockerSizeException.class)
  public void addMailInvalid2() throws LockerOccupiedException, ExceedLockerSizeException {
    testRecipient = new Recipient("wen", "xie", "wx@gmail.com");
    MailItem testMailItem1 = new MailItem(3, 2, 3, testRecipient);
    testLocker.addMail(testMailItem1);
  }

  @Test(expected = ExceedLockerSizeException.class)
  public void addMailInvalid3() throws LockerOccupiedException, ExceedLockerSizeException {
    testRecipient = new Recipient("wen", "xie", "wx@gmail.com");
    MailItem testMailItem2 = new MailItem(2, 4, 3, testRecipient);
    testLocker.addMail(testMailItem2);
  }

  @Test(expected = ExceedLockerSizeException.class)
  public void addMailInvalid4() throws LockerOccupiedException, ExceedLockerSizeException{
    testRecipient = new Recipient("wen", "xie", "wx@gmail.com");
    MailItem testMailItem3 = new MailItem(2,3,5, testRecipient);
    testLocker.addMail(testMailItem3);
    assertTrue(testLocker.getMailItem() == null);
  }

  @Test
  public void pickUpMail() throws EmptyLockerException, UnmatchedRecipientException,
      LockerOccupiedException, ExceedLockerSizeException{
    testRecipient = new Recipient("wen", "xie", "wx@gmail.com");
    testMailItem = new MailItem(1,2,3, testRecipient);
    testLocker.addMail(testMailItem);
    assertEquals(testMailItem, testLocker.pickUpMail(testRecipient));
    assertTrue(testLocker.getMailItem() == null);
  }

  @Test(expected = EmptyLockerException.class)
  public void pickUpMailInvalid1() throws EmptyLockerException, UnmatchedRecipientException,
      LockerOccupiedException, ExceedLockerSizeException{
    testRecipient = new Recipient("wen", "xie", "wx@gmail.com");
    MailItem pickUpItem = testLocker.pickUpMail(testRecipient);
  }

  @Test(expected = UnmatchedRecipientException.class)
  public void pickUpMailInvalid2() throws EmptyLockerException, UnmatchedRecipientException,
      LockerOccupiedException, ExceedLockerSizeException{
    testRecipient = new Recipient("wen", "xie", "wx@gmail.com");
    Recipient testRecipient2 = new Recipient("wen", "wen", "wx@gmail.com");
    testMailItem = new MailItem(1,2,3, testRecipient);
    testLocker.addMail(testMailItem);
    MailItem pickUpItem = testLocker.pickUpMail(testRecipient2);
  }
}