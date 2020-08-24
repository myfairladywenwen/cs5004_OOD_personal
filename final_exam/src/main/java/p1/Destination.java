package p1;

import java.util.Objects;

/**
 * Class represents a destination. The destination has a destination name, country, airport code and a
 * distance from Seattle, expressed as a Float.
 */
public class Destination {

  private String destinationName;
  private String country;
  private String airportCode;
  private Float distanceFromSeattle;

  /*
   * Constructs and returns a new object Destination, based upon the provided input arguments.
   * @param destinationName - a String, denoting the name of the destination
   * @param country - a String, denoting the country of the destination
   * @param airportCode - a String, denoting the airport code of the destination
   * @param distanceFromSeattle - a Float, denoting the distance between Seattle and the destination
   */
  public Destination(String destinationName, String country, String airportCode, Float distanceFromSeattle) {
    this.destinationName = destinationName;
    this.country = country;
    this.airportCode = airportCode;
    this.distanceFromSeattle = distanceFromSeattle;
  }

  /*
   * Method returns the name of the destination
   * @return - the name of the destination
   */
  public String getDestinationName() {
    return destinationName;
  }

  /*
   * Method returns the country of the destination
   * @return - the country of the destination
   */
  public String getCountry() {
    return country;
  }

  /*
   * Method returns the airport code of the destination
   * @return - the airport of the destination
   */
  public String getAirportCode() {
    return airportCode;
  }

  /*
   * Method returns the distance between Seattle and the destination
   * @return - the distance between Seattle and the destination
   */
  public Float getDistanceFromSeattle() {
    return distanceFromSeattle;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Destination that = (Destination) o;
    return destinationName.equals(that.destinationName) &&
        country.equals(that.country) &&
        airportCode.equals(that.airportCode) &&
        distanceFromSeattle.equals(that.distanceFromSeattle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinationName, country, airportCode, distanceFromSeattle);
  }
}
