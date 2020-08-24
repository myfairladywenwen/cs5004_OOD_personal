package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {

    private int testHour = 1;
    private int testMinutes = 10;
    private int testSeconds = 20;
    private int testSecondsWrong = 200;
    private int testHourWrong = 40;
    private int testMinutesWrong = 70;
    private Time testTime;
    @Before
    public void setUp() throws Exception {
        testTime = new Time(testHour, testMinutes, testSeconds);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid1() {
        Time wrongTime = new Time(testHourWrong, testMinutes,testSeconds);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid2() {
        Time wrongTime = new Time(-testHourWrong, testMinutes,testSeconds);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid3() {
        Time wrongTime = new Time(testHour, testMinutesWrong,testSeconds);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid4() {
        Time wrongTime = new Time(testHour, -testMinutesWrong,testSeconds);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid5() {
        Time wrongTime = new Time(testHour, testMinutes,testSecondsWrong);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid6() {
        Time wrongTime = new Time(testHour, testMinutes,-testSecondsWrong);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid7() {
        Time wrongTime = new Time(testHour, testMinutesWrong,testSecondsWrong);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid8() {
        Time wrongTime = new Time(testHour, -testMinutesWrong,-testSecondsWrong);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid9() {
        Time wrongTime = new Time(testHourWrong, testMinutes,testSecondsWrong);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid10() {
        Time wrongTime = new Time(-testHourWrong, testMinutes,-testSecondsWrong);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid11() {
        Time wrongTime = new Time(testHourWrong, testMinutesWrong,testSeconds);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid12() {
        Time wrongTime = new Time(-testHourWrong, -testMinutesWrong,testSeconds);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid13() {
        Time wrongTime = new Time(testHourWrong, testMinutesWrong,testSecondsWrong);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConstructorInvalid14() {
        Time wrongTime = new Time(-testHourWrong, -testMinutesWrong,-testSecondsWrong);
    }

    @Test
    public void getHour() {
        assertEquals(testHour, testTime.getHour());
    }

    @Test
    public void setHourValid() {
        testTime.setHour(testHour);
        assertEquals(testHour, testTime.getHour());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setHourInvalid() {
        testTime.setHour(testHourWrong);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setHourInvalid2() {
        testTime.setHour(-testHourWrong);
    }

    @Test
    public void getMinutes() {
        assertEquals(testMinutes, testTime.getMinutes());
    }

    @Test
    public void setMinutesValid() {
        testTime.setMinutes(testMinutes);
        assertEquals(testMinutes, testTime.getMinutes());
    }


    @Test(expected = IllegalArgumentException.class)
    public void setMinutesInvalid() {
        testTime.setMinutes(testMinutesWrong);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setMinutesInvalid2() {
        testTime.setMinutes(-testMinutesWrong);
    }

    @Test
    public void getSeconds() {
        assertEquals(testSeconds, testTime.getSeconds());
    }

    @Test
    public void setSecondsValid() {
        testTime.setSeconds(testSeconds);
        assertEquals(testSeconds, testTime.getSeconds());
    }


    @Test(expected = IllegalArgumentException.class)
    public void setSecondsInvalid() {
        testTime.setSeconds(testSecondsWrong);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setSecondsInvalid2() {
        testTime.setSeconds(-testSecondsWrong);
    }

    @Test
    public void earlierThan() {
        Time anotherTime1 = new Time(2,10,10);
        assertTrue(testTime.earlierThan(anotherTime1));
        anotherTime1.setHour(0);
        assertFalse(testTime.earlierThan(anotherTime1));
        anotherTime1.setHour(1);
        anotherTime1.setMinutes(9);
        assertFalse(testTime.earlierThan(anotherTime1));
        anotherTime1.setMinutes(11);
        assertTrue(testTime.earlierThan(anotherTime1));
        anotherTime1.setMinutes(10);
        anotherTime1.setSeconds(19);
        assertFalse(testTime.earlierThan(anotherTime1));
        anotherTime1.setSeconds(20);
        assertFalse(testTime.earlierThan(anotherTime1));
        anotherTime1.setSeconds(21);
        assertTrue(testTime.earlierThan(anotherTime1));
    }

    @Test
    public void timeEquals() {
        Time anotherTime1 = new Time(1,10,20);
        Time anotherTime2 = new Time(2,10,20);
        Time anotherTime3 = new Time(1,20,20);
        Time anotherTime4 = new Time(1,10,30);
        assertTrue(testTime.timeEquals(anotherTime1));
        assertFalse(testTime.timeEquals(anotherTime2));
        assertFalse(testTime.timeEquals(anotherTime3));
        assertFalse(testTime.timeEquals(anotherTime4));
    }

    @Test
    public void convertToSeconds() {
        assertEquals(4220,testTime.convertToSeconds());
    }

    @Test
    public void convertToTime() {
        Time resultTime = Time.convertToTime(4220);
        assertTrue(resultTime.timeEquals(testTime));
    }
}