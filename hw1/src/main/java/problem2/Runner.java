package problem2;

/**
 * Runner is an object that has a name, a team, a startTime and an endTime.
 */
public class Runner {
    private String name;
    private String team;
    private Time startTime;
    private Time endTime;

    /**
     * Constructor that creates a new Owner object with the specified name,team,
     * startTime, and endTime.
     * @param name
     * @param team
     * @param startTime
     * @param endTime
     */
    public Runner(String name, String team, Time startTime, Time endTime) {
        if (!startTime.earlierThan(endTime)){
            throw new IllegalArgumentException("invalid input");
        }
        this.name = name;
        this.team = team;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Return name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return team.
     * @return team
     */
    public String getTeam() {
        return team;
    }

    /**
     * Set team.
     * @param team
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * Return startTime.
     * @return startTime
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * Set startTime.
     * @param startTime
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * Return endTime.
     * @return endTime
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * Set endTime.
     * @param endTime
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    /**
     * the duration between startTime and endTime.
     * @return another Time
     */
    public Time getDuration(){
        int totalSeconds = this.getEndTime().convertToSeconds() - this.getStartTime().convertToSeconds();
        Time duration = Time.convertToTime(totalSeconds);
        return duration;
    }
}
