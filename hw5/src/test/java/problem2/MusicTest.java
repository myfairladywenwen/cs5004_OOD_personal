package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MusicTest {

  Music testM;

  @Before
  public void setUp() throws Exception {
    testM = new Music(new RecordingArtist("f", "l"), "thisMusic", 2000);
  }

  @Test
  public void testToString() {
    assertEquals(
        "Music{creator=RecordingArtist{firstName='f', lastName='l'}, title='thisMusic', publishYear=2000}",
        testM.toString());
  }

  @Test
  public void testEquals() {
    Music testM1 = new Music(new RecordingArtist("f", "l"), "thisMusic", 2000);
    assertTrue(testM.equals(testM1));
    assertTrue(testM.equals(testM));
    Music testM2 = new Music(new RecordingArtist("fff", "l"), "thisMusic", 2000);
    assertFalse(testM.equals(testM2));
    assertFalse(testM.equals(null));
    assertFalse(testM.equals("thisM"));

  }
}