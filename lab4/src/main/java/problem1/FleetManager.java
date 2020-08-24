package problem1;

import java.lang.Math;
public class FleetManager {

  public FleetManager() {
  }

  public TripReport drive(float distance, Vehicle vehicle){
     int duration = calDuration(distance, vehicle);
     float speedMilePerMin = calSpeed(distance, vehicle);
     TripReport  resultTripResult = new TripReport(vehicle, speedMilePerMin, distance, duration);
     return resultTripResult;
  }

  private int calDuration(float distance, Vehicle vehicle){
    return Math.round(distance/vehicle.avgSpeed);
  }

  private float calSpeed(float distance, Vehicle vehicle){
    return distance/ calDuration(distance, vehicle);
  }


}
