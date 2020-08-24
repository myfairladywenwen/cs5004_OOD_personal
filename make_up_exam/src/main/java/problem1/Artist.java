package problem1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Artist extends AbstractInfluencer {
   protected ArrayList<String> awards;
   protected Integer lastSeries;
   protected Double grossIncome;
   protected static final double ARTIST_FACTOR = 1.3;

   /**
    * Construcst an artist with specified name, dob, arraylist of soialmedia, arraylist of followers,
    * awards, lastest movie/TV series and gross income of the lastest series.
    * @param name a String representing the name of the influencer
    * @param dob a LoacalDate representing the date of birth of the influencer
    * @param socialMeds an arraylist representing the social media of the influencer
    * @param numOfFollowers an arraylist representing the followers of the social media of the influencer
    * @param awards an arraylist representing the awards
    * @param lastSeries an integer representing year of lastest series
    * @param grossIncome a Double representing grossIncome of lastest series
    * @throws ImpactEstimationException throws ImpactEstimationException if younger than 18
    */
   public Artist(String name, LocalDate dob,
       ArrayList<SocialMed> socialMeds, ArrayList<Integer> numOfFollowers,
       ArrayList<String> awards, Integer lastSeries, Double grossIncome)
       throws ImpactEstimationException {
      super(name, dob, socialMeds, numOfFollowers);
      this.awards = awards;
      this.lastSeries = lastSeries;
      this.grossIncome = grossIncome;
   }

   /**
    * estimate and return the influence
    *
    * @return a Double representing estimated influence.
    */
   @Override
   public Double estimateInfluence() {
      return super.estimateInfluence() * ARTIST_FACTOR;
   }

   /**
    * check whether two Artists are equal
    * @param o - object to be checked with
    * @return true or false
    */
   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      if (!super.equals(o)) {
         return false;
      }
      Artist artist = (Artist) o;
      return awards.equals(artist.awards) &&
          lastSeries.equals(artist.lastSeries) &&
          grossIncome.equals(artist.grossIncome);
   }

   /**
    * return the int representing the hashcode
    * @return the int representing the hashcode
    */
   @Override
   public int hashCode() {
      return Objects.hash(awards, lastSeries, grossIncome);
   }


   /**
    *
    * Returns a string representation of the object.
    * @return a string representation of the object.
    */
   @Override
   public String toString() {
      return "Artist{" +
          "awards=" + awards +
          ", lastSeries=" + lastSeries +
          ", grossIncome=" + grossIncome +
          ", name='" + name + '\'' +
          ", dob=" + dob +
          ", socialMeds=" + socialMeds +
          ", numOfFollowers=" + numOfFollowers +
          '}';
   }
}
