package problem1;

import java.util.Arrays;

public class AbstractGraphical extends AbstractArtist {
  protected String[] exhibits;

  public AbstractGraphical(Name name, Integer age, String[] genres, String[] awards,
      String[] exhibits) throws ExceedAgeLimitException {
    super(name, age, genres, awards);
    this.exhibits = exhibits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractGraphical)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    AbstractGraphical that = (AbstractGraphical) o;
    return Arrays.equals(exhibits, that.exhibits);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(exhibits);
    return result;
  }

  @Override
  public String toString() {
    return "AbstractGraphical{" +
        "exhibits=" + Arrays.toString(exhibits) +
        ", name=" + name +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }

  public String[] getExhibits() {
    return exhibits;
  }
}
