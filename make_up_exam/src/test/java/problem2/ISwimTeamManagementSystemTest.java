package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ISwimTeamManagementSystemTest {

  EmptySys emp = new EmptySys();
  DisciplineType d = DisciplineType.FREESTYLE;

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void isEmpty() {
    assertTrue(emp.isEmpty());
  }

  @Test
  public void add() {
  }

  @Test
  public void remove() {
  }

  @Test
  public void check() {
  }

  @Test
  public void count() {
    assertEquals(emp.count(), 0);
  }

  @Test (expected = SwimmerNotFoundException.class)
  public void findAllInDisipline() throws SwimmerNotFoundException {
    emp.FindAllInDisipline(d);
  }
}