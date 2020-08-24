package problem1;

import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractArtist implements ArtistInterface{
    protected Name name;
    protected Integer age;
    protected String[] genres;
    protected String[] awards;

  public AbstractArtist(Name name, Integer age, String[] genres, String[] awards)
      throws ExceedAgeLimitException{
    if (age > 128 || age < 0){
      throw new ExceedAgeLimitException("wrong age.");
    }
    this.name = name;
    this.age = age;
    this.genres = genres;
    this.awards = awards;
  }

  protected void updateAwards(String award){
    if (this.awards == null) {
      this.awards = new String[1];
    } else {
      String[] newAwards = new String[this.awards.length + 1];
      for (int i = 0; i < this.awards.length; i++) {
        newAwards[i] = this.awards[i];
      }
      this.awards = newAwards;
    }
    this.awards[this.awards.length] = award;
  }

  @Override
  public String toString() {
    return "Artist{" +
        "name=" + name +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractArtist)) {
      return false;
    }
    AbstractArtist artist = (AbstractArtist) o;
    return getName().equals(artist.getName()) &&
        getAge().equals(artist.getAge()) &&
        Arrays.equals(getGenres(), artist.getGenres()) &&
        Arrays.equals(getAwards(), artist.getAwards());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getName(), getAge());
    result = 31 * result + Arrays.hashCode(getGenres());
    result = 31 * result + Arrays.hashCode(getAwards());
    return result;
  }

  public Name getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String[] getGenres() {
    return genres;
  }

  public String[] getAwards() {
    return awards;
  }
}
