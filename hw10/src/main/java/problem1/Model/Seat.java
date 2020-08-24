package problem1.Model;

import java.util.Objects;

/**
 * Seat is an object with name and reserved for whom
 */
public class Seat {
  private String seatName;     // A-Z
  private String reservedFor;   // reserved for whom

  /**
   * Constructs a Seat with given seatName
   * @param seatName a string
   */
  public Seat(String seatName) {
    this.seatName = seatName;
    this.reservedFor = null;
  }

  /**
   * Constructs a Seat with given seatName and reserved for whom
   * @param seatName a String
   * @param reservedFor  a String
   */
  public Seat(String seatName, String reservedFor) {
    this.seatName = seatName;
    this.reservedFor = reservedFor;
  }

  /**
   * Return the seat is reserved for whom
   * @return a String
   */
  public String getReservedFor() {
    return reservedFor;
  }

  /**
   * Return the seat name
   * @return a String
   */
  public String getSeatName() {
    return seatName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Seat seat = (Seat) o;
    return Objects.equals(seatName, seat.seatName) &&
        Objects.equals(reservedFor, seat.reservedFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seatName, reservedFor);
  }

  @Override
  public String toString() {
    return "Seat{" +
        "seatName='" + seatName + '\'' +
        ", reservedFor='" + reservedFor + '\'' +
        '}';
  }
}
