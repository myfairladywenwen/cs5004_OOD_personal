package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecordingArtistTest {

  RecordingArtist testArtist;

  @Before
  public void setUp() throws Exception {
    testArtist = new RecordingArtist("f", "l");
  }

  @Test
  public void testToString() {
    assertEquals("RecordingArtist{firstName='f', lastName='l'}", testArtist.toString());
  }
}