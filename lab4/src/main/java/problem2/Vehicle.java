package problem2;

import java.util.Objects;

public abstract class Vehicle {
  protected String ID;
  protected Float avgSpeed;
  protected Float maxSpeed;

  /**
   * Constructor
   * @param ID
   * @param avgSpeed
   * @param maxSpeed
   */
  public Vehicle(String ID, Float avgSpeed, Float maxSpeed) {
    this.ID = ID;
    this.avgSpeed = avgSpeed;
    this.maxSpeed = maxSpeed;
  }

  public Float getAvgSpeed() {
    return avgSpeed;
  }

  public Float getMaxSpeed() {
    return maxSpeed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return ID.equals(vehicle.ID) &&
        avgSpeed.equals(vehicle.getAvgSpeed()) &&
        maxSpeed.equals(vehicle.maxSpeed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, avgSpeed, maxSpeed);
  }
}
