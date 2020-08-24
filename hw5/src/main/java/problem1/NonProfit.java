package problem1;

import java.time.LocalDate;
import java.util.List;

/**
 * Nonprofit is an object that tracks different types of Donations
 */
public class NonProfit {

  private String name;
  private List<Donation> list;

  /**
   * Constructs a Nonprofit object with specified name and list of Donations
   *
   * @param name - a String representing the name of the Nonprofit
   * @param list - a list of Donations
   */
  public NonProfit(String name, List<Donation> list) {
    this.name = name;
    this.list = list;
  }

  /**
   * Returns the sum of the donations of specific year
   *
   * @param year - an Integer representing the inquiry year
   * @return - an Integer of the sum of Donations of that year
   */
  Integer getTotalDonationsForYear(Integer year) {
    LocalDate dueDate = convertToDueDate(year);
    Integer sum = 0;
    for (Donation donation : this.list) {
      sum += donation.getContribute(dueDate);
    }
    return sum;
  }

  /**
   * A helper to convert the given year to the last day of the year, so as to calculate and compare
   * the correct range for different subtypes of Donation
   *
   * @param year - integer representing a year
   * @return a LocalDate representing the last day of the given year
   */
  private LocalDate convertToDueDate(Integer year) {
    LocalDate dueDate = LocalDate.of(year, 12, 31);
    return dueDate;
  }

  /**
   * Add a donation to the list
   *
   * @param d - the donation to be added
   */
  public void addDonation(Donation d) {
    this.list.add(d);
  }

  /**
   * Remove a donation from the list
   *
   * @param d - the donation to be removed
   */
  public void removeDonation(Donation d) {
    if (d != null) {
      this.list.remove(d);
    }
  }

}
