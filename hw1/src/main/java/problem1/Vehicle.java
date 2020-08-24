package problem1;
/**
 * Vehicle is a simple object that has a unique Vehicle Identification Number(VIN) and
 * corresponding license plate, and owner.
 */
public class Vehicle {
    private Integer VIN;
    private String licensePlate;
    private Owner vehicleOwner;
    /** 
     * Constructor that creates a new vehicle object with the specified VIN and
     * license plate.
     * @param VIN - VIN of the new Vehicle object.
     * @param licensePlate license plate of the new Vehicle.
     */
    public Vehicle(Integer VIN, String licensePlate, Owner vehicleOwner){
        this.VIN = VIN;
        this.licensePlate = licensePlate;
        this.vehicleOwner = vehicleOwner;
    }

    /**
     * returns the VIN of the Vehicle.
     * @return the VIN of the Vehicle.
     */
    public Integer getVIN() {
        return this.VIN;
    }

    /**
     * returns the licensePlate of the Vehicle.
     * @return the licensePlate of the Vehicle.
     */
    public String getLicensePlate() {
        return this.licensePlate;
    }

    /**
     * returns the vehicleOwner of the Vehicle.
     * @return the vehicleOwner of the Vehicle.
     */
    public Owner getVehicleOwner(){
        return this.vehicleOwner;
    }
    /**
     * sets the VIN of the Vehicle.
     * @param VIN
     */
    public void setVIN(Integer VIN) {
        this.VIN = VIN;
    }

    /**
     * sets the licensePlate of the Vehicle.
     * @param licensePlate
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * sets the vehicleOwner of the Vehicle.
     * @param vehicleOwner
     */
    public void setVehicleOwner(Owner vehicleOwner){
        this.vehicleOwner = vehicleOwner;
    }
}