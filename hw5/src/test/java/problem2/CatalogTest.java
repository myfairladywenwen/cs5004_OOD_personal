package problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class CatalogTest {

  Catalog testCataLog;
  ArrayList<Item> testlist;

  @Before
  public void setUp() throws Exception {
    testlist = new ArrayList<>();
    testCataLog = new Catalog(testlist);
  }


  @Test
  public void testAddItem() {
    Book b1 = new Book(new Author("f1", "l1"), "Book1", 2000);
    testCataLog.addItem(b1);
    ArrayList<Item> testlist1 = new ArrayList<>();
    testlist1.add(b1);
    assertEquals(testCataLog.cataList, testlist1);
  }

  @Test
  public void testAddItem1() {
    Book b1 = null;
    testCataLog.addItem(b1);
    ArrayList<Item> testlist1 = new ArrayList<>();
    assertEquals(testCataLog.cataList, testlist1);
  }

  @Test
  public void testsearch1() {  //test search by keyword
    Book b1 = new Book(new Author("f1", "l1"), "BookA", 2000);
    Book b2 = new Book(new Author("f2", "l1"), "BookB", 2000);
    Book b3 = new Book(new Author("f3", "l1"), "Booka", 2000);
    Music m1 = new Music(new RecordingArtist("rf1", "rl1"), "MusicA", 2000);
    Music m2 = new Music(new RecordingArtist("rf2", "rl2"), "MusicB", 2000);
    Music m3 = new Music(new RecordingArtist("rf3", "rl3"), "Musica", 2000);
    testCataLog.addItem(b1);
    testCataLog.addItem(b2);
    testCataLog.addItem(b3);
    testCataLog.addItem(m1);
    testCataLog.addItem(m2);
    testCataLog.addItem(m3);
    ArrayList<Item> result = testCataLog.search("a");
    ArrayList<Item> expected = new ArrayList<>();
    expected.add(b1);
    expected.add(b3);
    expected.add(m1);
    expected.add(m3);
    assertEquals(result, expected);
  }

  @Test
  public void testSearch2() {  // test search by Author
    Book b1 = new Book(new Author("f1", "l1"), "BookA", 2000);
    Book b2 = new Book(new Author("f1", "l1"), "BookB", 2001);
    Book b3 = new Book(new Author("f2", "l2"), "Booka", 2000);
    Music m1 = new Music(new RecordingArtist("rf1", "rl1"), "MusicA", 2000);
    Music m2 = new Music(new RecordingArtist("rf2", "rl2"), "MusicB", 2000);
    testCataLog.addItem(b1);
    testCataLog.addItem(b2);
    testCataLog.addItem(b3);
    testCataLog.addItem(m1);
    testCataLog.addItem(m2);
    ArrayList<Item> expected = new ArrayList<>();
    expected.add(b1);
    expected.add(b2);
    ArrayList<Item> result = testCataLog.search(new Author("f1", "l1"));
    assertEquals(result, expected);
  }

  @Test
  public void testSearch3() {  // test search by RecordingArtist
    Book b1 = new Book(new Author("f1", "l1"), "BookA", 2000);
    Book b2 = new Book(new Author("f2", "l1"), "BookB", 2000);
    Book b3 = new Book(new Author("f3", "l1"), "Booka", 2000);
    Music m1 = new Music(new RecordingArtist("rf1", "rl1"), "MusicA", 2000);  // target is m1
    Music m2 = new Music(new RecordingArtist("rf2", "rl2"), "MusicB", 2000);
    Music m3 = new Music(new RecordingArtist("rf3", "rl3"), "Musica", 2000);
    ArrayList<RecordingArtist> artistlist1 = new ArrayList<>();
    artistlist1.add(new RecordingArtist("rf1", "rl1"));
    artistlist1.add(new RecordingArtist("rf10", "rl10"));
    artistlist1.add(new RecordingArtist("rf100", "rl100"));
    Group g1 = new Group("group1", artistlist1);
    Music m4 = new Music(g1, "title1", 2000);  // target is a member of g1
    testCataLog.addItem(b1);
    testCataLog.addItem(b2);
    testCataLog.addItem(b3);
    testCataLog.addItem(m1);
    testCataLog.addItem(m2);
    testCataLog.addItem(m3);
    testCataLog.addItem(m4);
    ArrayList<Item> result = testCataLog.search(new RecordingArtist("rf1", "rl1"));
    ArrayList<Item> expected = new ArrayList<>();
    expected.add(m1);
    expected.add(m4);
    assertEquals(result, expected);
  }

  @Test
  public void testRemoveItem() throws EmptyCatalogException {
    Book b1 = new Book(new Author("f1", "l1"), "BookA", 2000);
    Book b2 = new Book(new Author("f2", "l1"), "BookB", 2000);
    Music m1 = new Music(new RecordingArtist("rf1", "rl1"), "MusicA", 2000);
    testCataLog.addItem(b1);
    testCataLog.addItem(b2);
    testCataLog.removeItem(b1);
    assertEquals(1, testCataLog.size());
    assertFalse(testCataLog.cataList.contains(b1));
  }

  @Test
  public void testRemoveItem2() throws EmptyCatalogException {
    Book b1 = new Book(new Author("f1", "l1"), "BookA", 2000);
    Book b2 = new Book(new Author("f2", "l1"), "BookB", 2000);
    Music m1 = new Music(new RecordingArtist("rf1", "rl1"), "MusicA", 2000);
    testCataLog.addItem(b1);
    testCataLog.addItem(b2);
    testCataLog.removeItem(m1);
    assertEquals(2, testCataLog.size());
  }

  @Test(expected = EmptyCatalogException.class)
  public void testRemoveItemInvalid() throws EmptyCatalogException {
    Book b1 = new Book(new Author("f1", "l1"), "BookA", 2000);
    Book b2 = new Book(new Author("f2", "l1"), "BookB", 2000);
    testCataLog.addItem(b1);
    testCataLog.removeItem(b1);
    testCataLog.removeItem(b2);
  }

  @Test
  public void testSize() {
    Book b1 = new Book(new Author("f1", "l1"), "BookA", 2000);
    testCataLog.addItem(b1);
    assertEquals(1, testCataLog.size());
  }

  @Test
  public void testEquals() {
    Book b1 = new Book(new Author("f1", "l1"), "BookA", 2000);
    Book b2 = new Book(new Author("f2", "l1"), "BookB", 2000);
    testCataLog.addItem(b1);
    testCataLog.addItem(b2);
    ArrayList<Item> testlist2 = new ArrayList<>();
    Catalog testCataLog2 = new Catalog(testlist2);
    testCataLog2.addItem(b1);
    testCataLog2.addItem(b2);
    assertTrue(testCataLog.equals(testCataLog2));
    assertTrue(testCataLog.equals(testCataLog));
    testCataLog2.addItem(b1);
    assertFalse(testCataLog.equals(testCataLog2));
    assertFalse(testCataLog.equals(null));
    assertFalse(testCataLog.equals("that"));
  }

  @Test
  public void testHashCode() {
    Book b1 = new Book(new Author("f1", "l1"), "BookA", 2000);
    Book b2 = new Book(new Author("f2", "l1"), "BookB", 2000);
    testCataLog.addItem(b1);
    testCataLog.addItem(b2);
    ArrayList<Item> testlist2 = new ArrayList<>();
    Catalog testCataLog2 = new Catalog(testlist2);
    testCataLog2.addItem(b1);
    testCataLog2.addItem(b2);
    assertEquals(testCataLog.hashCode(), testCataLog2.hashCode());
    testCataLog2.addItem(b1);
    assertNotEquals(testCataLog.hashCode(), testCataLog2.hashCode());
  }

  @Test
  public void testToString() {
    Book b1 = new Book(new Author("f1", "l1"), "BookA", 2000);
    Book b2 = new Book(new Author("f2", "l1"), "BookB", 2000);
    testCataLog.addItem(b1);
    testCataLog.addItem(b2);
    assertEquals(
        "Catalog{cataList=[Book{Author=Author{firstName='f1', lastName='l1'}, title='BookA', publishYear=2000}, Book{Author=Author{firstName='f2', lastName='l1'},"
            + " title='BookB', publishYear=2000}]}",
        testCataLog.toString());
  }
}