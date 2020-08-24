package p1;

import java.util.List;

/**
 * Class represents a customer. The customer has a first name, last name and a
 * list of items they bought in the last year.
 */
class Customer {
    private String firstName;
    private String lastName;
    private List<Item> boughtItems;


    /**
     * Constructs a Customer object and initializes it
     * to the given first name, last name and the list of bought products
     * @param firstName the first name of this person
     * @param lastName the last name of this person
     * @param boughtItems list of items they bought in the last year.
     */

    public Customer(String firstName, String lastName, List<Item> boughtItems) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.boughtItems = boughtItems;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public List<Item> getBoughtItems() {
        return boughtItems;
    }
}
