package p3;
import java.util.Objects;

/*
 * Class Restaurant contains information about restaurant.
 */
public class Restaurant {

  private String restaurantName;
  private String address;
  private String cuisine;

  /*
   * Constructor for object Restaurant.
   * @param restaurantName - restaurant name, as a String
   * @param address - restaurant address, as a String
   * @param cuisine - attribute defining the dominant cuisine offered
   * by the restaurant
   */
  public Restaurant(String restaurantName, String address,
                    String cuisine) {
    this.restaurantName = restaurantName;
    this.address = address;
    this.cuisine = cuisine;
  }

  /*
   * Getter for parameter restaurantsName.
   * @return restaurantsName - String, representing a restaurant's name */
  public String getRestaurantName() {
    return restaurantName;
  }

  /*
   * Getter for parameter address.
   * @return address - String, representing a restaurant's address */
  public String getAddress() {
    return address;
  }

  /*
   * Getter for parameter cuisine.
   * @return cuisine - String representing the dominant
   * cuisine offered by the restaurant */
  public String getCuisine() {
    return cuisine;
  }

}
