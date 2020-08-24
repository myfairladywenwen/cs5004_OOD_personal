package problem2;

import java.util.InputMismatchException;

public class FleetManager {
  private static final Float DEFAULT_DISTANCE = 100f;

  public FleetManager() {
  }

  public TripReport drive(float distance, Vehicle vehicle){
     int duration = calDuration(distance, vehicle);
     float speedMilePerMin = calSpeed(distance, vehicle);
     TripReport resultTripResult = new TripReport(vehicle, speedMilePerMin, distance, duration);
     return resultTripResult;
  }

  private int calDuration(float distance, Vehicle vehicle){
    return Math.round(distance/vehicle.getAvgSpeed());
  }

  private float calSpeed(float distance, Vehicle vehicle){
    return distance/calDuration(distance, vehicle);
  }


  public TripReport drive(Vehicle vehicle){
    return drive(DEFAULT_DISTANCE, vehicle);
  }

  public TripReport drive(Vehicle vehicle, Float distance, Integer duration){
    return new TripReport(vehicle, vehicle.avgSpeed, distance, duration);
  }

  public TripReport drive(Vehicle vehicle, Float distance, Integer duration, Float speed){
    if (!validateSpeed(vehicle, speed)){
      return new TripReport(vehicle, speed, distance, duration);
    }else{
      throw new InputMismatchException("Vehicle speed exceed max");
    }
  }


  //helper
  private boolean validateSpeed(Vehicle vehicle, Float speed){
    return vehicle.getMaxSpeed() < speed;
  }



//  public TripReport drive(Boat boat, Float distance){
//    return drive((Vehicle)boat, distance);
//
//  }
//  public TripReport drive(Train train, Float distance){
//
//  }
//  public TripReport drive(Bus bus, Float distance){
//
//  }

}
