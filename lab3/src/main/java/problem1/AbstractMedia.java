package problem1;

import java.util.Arrays;

public abstract class AbstractMedia extends AbstractArtist {
  protected String[] movies;
  protected String[] series;
  protected String[] multimedia;

  public AbstractMedia(Name name, Integer age, String[] genres, String[] awards,
      String[] movies, String[] series, String[] multimedia) throws ExceedAgeLimitException {
    super(name, age, genres, awards);
    this.movies = movies;
    this.series = series;
    this.multimedia = multimedia;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractMedia)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    AbstractMedia that = (AbstractMedia) o;
    return Arrays.equals(movies, that.movies) &&
        Arrays.equals(series, that.series) &&
        Arrays.equals(multimedia, that.multimedia);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(movies);
    result = 31 * result + Arrays.hashCode(series);
    result = 31 * result + Arrays.hashCode(multimedia);
    return result;
  }

  @Override
  public String toString() {
    return "AbstractMedia{" +
        "movies=" + Arrays.toString(movies) +
        ", series=" + Arrays.toString(series) +
        ", multimedia=" + Arrays.toString(multimedia) +
        ", name=" + name +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }
}
