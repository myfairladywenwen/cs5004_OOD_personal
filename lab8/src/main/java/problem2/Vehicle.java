package problem2;

import java.awt.Color;
import java.util.Objects;

public class Vehicle {
  private String make;
  private String model;
  private Integer year;
  private Color vehicleColor;

  public Vehicle(String make, String model, Integer year, Color vehicleColor){
    this.make = make;
    this.model = model;
    this.year = year; this.vehicleColor = vehicleColor;
  }

  public String getMake() { return make; }

  public String getModel() { return model; }

  public Integer getYear() { return year; }

  public Color getVehicleColor() { return vehicleColor; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Vehicle)) return false;
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(getMake(), vehicle.getMake());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMake()); }

  @Override
  public String toString() {
    return "Vehicle{" +
        "make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        ", vehicleColor=" + vehicleColor +
        '}';
  }
}

