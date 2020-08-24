package problem2;

import java.util.Objects;

public class TripReport {
  protected Vehicle vehicle;
  protected Float speedMilePerMin;
  protected Float distanceInMiles;
  protected Integer duration;

  /**
   * Constructor
   */
  public TripReport(Vehicle vehicle, Float speedMilePerMin, Float distanceInMiles,
      Integer duration) {
    this.vehicle = vehicle;
    this.speedMilePerMin = speedMilePerMin;
    this.distanceInMiles = distanceInMiles;
    this.duration = duration;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public Float getSpeedMilePerMin() {
    return speedMilePerMin;
  }

  public Float getDistanceInMiles() {
    return distanceInMiles;
  }

  public Integer getDuration() {
    return duration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TripReport that = (TripReport) o;
    return vehicle.equals(that.vehicle) &&
        speedMilePerMin.equals(that.getSpeedMilePerMin()) &&
        distanceInMiles.equals(that.getDistanceInMiles()) &&
        duration.equals(that.getDuration());
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicle, speedMilePerMin, distanceInMiles, duration);
  }
}
