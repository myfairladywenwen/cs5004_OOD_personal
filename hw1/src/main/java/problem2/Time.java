package problem2;

import problem3.Person;

/**
 * Time is an object that has an hour, a minutes, and a seconds.
 */
public class Time {
    private int hour;
    private int minutes;
    private int seconds;
    private final int HOUR_LOW_BOUND = 0;
    private final int HOUR_HIGH_BOUND = 23;
    private final int MIN_LOW_BOUND = 0;
    private final int MIN_HIGH_BOUND = 59;
    private final int SECONDS_LOW_BOUND = 0;
    private final int SECONDS_HIGH_BOUND = 59;
    private static final int SECONDS_PER_MIN = 60;
    private static final int MIN_PER_HOUR = 60;

    /**
     * Constructor that creates a new Time object with the specified hour, minutes and seconds.
     *
     * @param hour
     * @param minutes
     * @param seconds
     */
    public Time(int hour, int minutes, int seconds) {
        if ((hour >= HOUR_LOW_BOUND && hour <= HOUR_HIGH_BOUND) &&
                (minutes >= MIN_LOW_BOUND && minutes <= MIN_HIGH_BOUND) &&
                (seconds >= SECONDS_LOW_BOUND && seconds <= SECONDS_HIGH_BOUND)) {
            this.hour = hour;
            this.minutes = minutes;
            this.seconds = seconds;
        } else {
            throw new IllegalArgumentException("Invalid Input");
        }
    }

    /**
     * Return hour.
     *
     * @return hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * Set hour.
     *
     * @param hour
     */
    public void setHour(int hour) {
        if (hour < HOUR_LOW_BOUND || hour > HOUR_HIGH_BOUND) {
            throw new IllegalArgumentException("Invalid Input");
        } else {
            this.hour = hour;
        }
    }

    /**
     * Return minutes.
     *
     * @return minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Set minutes.
     *
     * @param minutes
     */
    public void setMinutes(int minutes) {
        if (minutes < MIN_LOW_BOUND || minutes > MIN_HIGH_BOUND) {
            throw new IllegalArgumentException("Invalid Input");
        } else {
            this.minutes = minutes;
        }
    }

    /**
     * Return seconds.
     *
     * @return seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Set seconds.
     *
     * @param seconds
     */
    public void setSeconds(int seconds) {
        if (seconds < SECONDS_LOW_BOUND || seconds > SECONDS_HIGH_BOUND) {
            throw new IllegalArgumentException("Invalid Input");
        } else {
            this.seconds = seconds;
        }
    }

    /**
     * Return true if the calling object is earlier(smaller) than the passing in Time,
     * otherwise,return false.
     * @param anotherTime
     * @return boolean
     */
    public boolean earlierThan(Time anotherTime) {
        if (this.getHour() > anotherTime.getHour()) {
            return false;
        }
        if (this.getHour() == anotherTime.getHour()) {
            if (this.getMinutes() > anotherTime.getMinutes()) {
                return false;
            } else if (this.getMinutes() == anotherTime.getMinutes()) {
                return this.getSeconds() < anotherTime.getSeconds();
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    /**
     * return true if two Time has the same hour, minutes, and seconds, otherwise return false.
     * @param anotherTime
     * @return boolean
     */
    public boolean timeEquals(Time anotherTime) {
        return (this.getHour() == anotherTime.getHour() &&
                this.getMinutes() == anotherTime.getMinutes() &&
                this.getSeconds() == anotherTime.getSeconds());
    }

    /**
     * Return the int value of seconds of Time object.
     * @return int
     */
    public int convertToSeconds() {
        return this.getHour() * SECONDS_PER_MIN * MIN_PER_HOUR +
                this.getMinutes() * SECONDS_PER_MIN + this.getSeconds();
    }

    /**
     * Return the corresponding Time object of the passing in seconds.
     * @param seconds
     * @return Time
     */
    public static Time convertToTime(int seconds) {
        int resultHour = seconds / (SECONDS_PER_MIN * MIN_PER_HOUR);
        int resultMinInSeconds = seconds % (SECONDS_PER_MIN * MIN_PER_HOUR);
        int resultMin = resultMinInSeconds / SECONDS_PER_MIN;
        int resultSeconds = resultMinInSeconds % SECONDS_PER_MIN;
        return new Time(resultHour, resultMin, resultSeconds);
    }
}
