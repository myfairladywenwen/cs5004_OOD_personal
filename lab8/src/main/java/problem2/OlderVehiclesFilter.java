package problem2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehiclesFilter {
  private List<Vehicle> vehicles = new ArrayList<>();

  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }


  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3){
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle2);
  }

  /**
   * print out make, model and year of all the vehicles manufactured after 1999.
   * @param year int representing the year as a benchmark
   * @return a List</String> representing the filtered older vehicles, of theri make, model and year
   */
  public List<String> filterVWvehilces(int year) {
    List<Vehicle> resultV = new ArrayList<>();
    resultV = this.vehicles.stream().filter(v->v.getYear() > year)
        .collect(Collectors.toList());
    List<String> resultStringList = new ArrayList<>();
    resultStringList = resultV.stream()
        .map(v-> "make: " + v.getMake() + " model: " + v.getModel() + " year: " + Integer.toString(v.getYear()))
        .collect(Collectors.toList());
    System.out.println(resultStringList);
    return resultStringList;
  }

  public static void main(String[] args){
    Vehicle v1 = new Vehicle("make1", "model1", 1990, Color.BLACK);
    Vehicle v2 = new Vehicle("make2", "model2", 1995, Color.RED);
    Vehicle v3 = new Vehicle("make3", "model3", 1999, Color.BLACK);
    Vehicle v4 = new Vehicle("make4", "model4", 2000, Color.RED);
    Vehicle v5 = new Vehicle("make5", "model5", 2010, Color.BLACK);
    List<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(v1);
    vehicles.add(v2);
    vehicles.add(v3);
    vehicles.add(v4);
    vehicles.add(v5);

    OlderVehiclesFilter f = new OlderVehiclesFilter(vehicles);
    f.filterVWvehilces(1999);
  }
}
