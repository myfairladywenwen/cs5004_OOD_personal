package p3;

import p1.Item;

import java.util.List;

/**
 * Class represents a guest, who is a restaurant customer. The guest has a first name, last name and a
 * list of restaurants they visited in the last year.
 */
class Guest {
    private String firstName;
    private String lastName;
    private List<Restaurant> visitedRestaurant;


    /**
     * Constructs a Customer object and initializes it
     * to the given first name, last name and the list of bought products
     * @param firstName the first name of this person
     * @param lastName the last name of this person
     * @param visitedRestaurant list of restaurants they visited in the last year.
     */

    public Guest(String firstName, String lastName, List<Restaurant> visitedRestaurant) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.visitedRestaurant = visitedRestaurant;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Restaurant> getVisitedRestaurant() {
        return visitedRestaurant;
    }
}
