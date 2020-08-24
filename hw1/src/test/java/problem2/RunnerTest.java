package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RunnerTest {

    private Runner testRunner;
    private String testName = "wen";
    private String testTeam = "NEU";
    private int testHour = 1;
    private int testHourEnd = 2;
    private int testMin = 10;
    private int testMinEnd = 20;
    private int testSec = 20;
    private int testSecEnd = 30;
    private Time testStartTime = new Time(testHour, testMin, testSec);
    private Time testEndTime = new Time(testHourEnd, testMinEnd, testSecEnd);
    private Time wrongEndTime = new Time(1, 10, 20);

    @Before
    public void setUp() throws Exception {
        testRunner = new Runner (testName, testTeam, testStartTime, testEndTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid(){
        Runner wrongRunner = new Runner(testName, testTeam, testStartTime, wrongEndTime);
    }

    @Test
    public void getName() {
        assertEquals(testName, testRunner.getName());
    }

    @Test
    public void setName() {
        testRunner.setName("wenwen");
        assertEquals("wenwen", testRunner.getName());
    }

    @Test
    public void getTeam() {
        assertEquals(testTeam, testRunner.getTeam());
    }

    @Test
    public void setTeam() {
        testRunner.setTeam("NEUSea");
        assertEquals("NEUSea", testRunner.getTeam());
    }

    @Test
    public void getStartTime() {
        assertEquals(testStartTime, testRunner.getStartTime());
    }

    @Test
    public void setStartTime() {
        Time newStartTime = new Time(2, 30, 40);
        testRunner.setStartTime(newStartTime);
        assertTrue(testRunner.getStartTime().timeEquals(newStartTime));
    }

    @Test
    public void getEndTime() {
        assertEquals(testEndTime, testRunner.getEndTime());
    }

    @Test
    public void setEndTime() {
        Time newEndTime = new Time(3, 40, 50);
        testRunner.setEndTime(newEndTime);
        assertTrue(testRunner.getEndTime().timeEquals(newEndTime));
    }

    @Test
    public void getDuration() {
        Time duration =  new Time(1,10,10);
        assertTrue(duration.timeEquals(testRunner.getDuration()));
    }
}