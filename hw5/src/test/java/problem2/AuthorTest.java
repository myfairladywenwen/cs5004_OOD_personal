package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AuthorTest {

  Author testAuthor;

  @Before
  public void setUp() throws Exception {
    testAuthor = new Author("f", "l");
  }

  @Test
  public void testToString() {
    assertEquals("Author{firstName='f', lastName='l'}", testAuthor.toString());
  }
}