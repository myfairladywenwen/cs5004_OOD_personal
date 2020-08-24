package problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class GroupTest {

  Group testGroup;
  ArrayList<RecordingArtist> memberlist;

  @Before
  public void setUp() throws Exception {
    memberlist = new ArrayList<>();
    testGroup = new Group("group", memberlist);
  }

  @Test
  public void testEquals() {
//    memberlist = new ArrayList<>();
//    testGroup = new Group("group", memberlist);
    RecordingArtist a1 = new RecordingArtist("f1", "l1");
    RecordingArtist a2 = new RecordingArtist("f2", "l2");
    RecordingArtist a3 = new RecordingArtist("f3", "l3");
    memberlist.add(a1);
    memberlist.add(a2);
    memberlist.add(a3);
    ArrayList<RecordingArtist> memberlist1 = new ArrayList<>();
    memberlist1.add(new RecordingArtist("f1", "l1"));
    memberlist1.add(new RecordingArtist("f2", "l2"));
    memberlist1.add(new RecordingArtist("f3", "l3"));
    Group testGroup1 = new Group("group", memberlist1);
    assertTrue(testGroup.equals(testGroup1));
    assertTrue(testGroup.equals(testGroup));
    assertFalse(testGroup.equals("that"));
    assertFalse(testGroup.equals(null));

    ArrayList<RecordingArtist> memberlist2 = new ArrayList<>();
    memberlist1.add(new RecordingArtist("f1", "l1"));
    Group testGroup2 = new Group("group", memberlist2);
    assertFalse(testGroup.equals(testGroup2));
    Group testGroup3 = new Group("grouppp", memberlist2);
    assertFalse(testGroup.equals(testGroup3));
  }


  @Test
  public void testHashCode() {
    RecordingArtist a1 = new RecordingArtist("f1", "l1");
    RecordingArtist a2 = new RecordingArtist("f2", "l2");
    RecordingArtist a3 = new RecordingArtist("f3", "l3");
    memberlist.add(a1);
    memberlist.add(a2);
    memberlist.add(a3);
    ArrayList<RecordingArtist> memberlist1 = new ArrayList<>();
    memberlist1.add(new RecordingArtist("f1", "l1"));
    memberlist1.add(new RecordingArtist("f2", "l2"));
    memberlist1.add(new RecordingArtist("f3", "l3"));
    Group testGroup1 = new Group("group", memberlist1);
    assertEquals(testGroup.hashCode(), testGroup1.hashCode());
    memberlist1.remove(a1);
    assertNotEquals(testGroup.hashCode(), testGroup1.hashCode());
  }

  @Test
  public void testToString() {
    RecordingArtist a1 = new RecordingArtist("f1", "l1");
    RecordingArtist a2 = new RecordingArtist("f2", "l2");
    RecordingArtist a3 = new RecordingArtist("f3", "l3");
    memberlist.add(a1);
    memberlist.add(a2);
    memberlist.add(a3);
    assertEquals(
        "Group{name='group', list=[RecordingArtist{firstName='f1', lastName='l1'}, RecordingArtist{firstName='f2', lastName='l2'}, RecordingArtist{firstName='f3', lastName='l3'}]}",
        testGroup.toString());
  }
}