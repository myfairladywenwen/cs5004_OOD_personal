public class Address {
    private int streetNo;
    private String streetName;
    private String cityName;
    private String stateAc;
    private int zipcode;

    public Address(int streetNo, String streetName, String cityName, String stateAc, int zipcode){
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.cityName = cityName;
        this.stateAc = stateAc;
        this.zipcode = zipcode;
    }

    public int getStreetNo(){
        return this.streetNo;
    }
    public String getStreetName(){
        return this.streetName;
    }
    public String getCityName(){
        return this.cityName;
    }
    public String getStateAc(){
        return this.stateAc;
    }
    public int getZipcode(){
        return this.zipcode;
    }
    public String getAddress(){
        return this.getStreetNo() + " " +
                this.getStreetName() + ", " +
                this.getCityName() + " " +
                this.getStateAc() + " " +
                this.getZipcode();
    }
}
