package problem1;

import java.util.Arrays;
import java.util.Objects;

public class Poet extends AbstractArtist {
  private String pubCo;
  private String lastPubCollection;

  public Poet(Name name, Integer age, String[] genres, String[] awards, String pubCo,
      String lastPubCollection) throws ExceedAgeLimitException {
    super(name, age, genres, awards);
    this.pubCo = pubCo;
    this.lastPubCollection = lastPubCollection;
  }


  public AbstractArtist receiveAwards(String award)throws ExceedAgeLimitException {
    updateAwards(award);
    return new Poet(this.name, this.age, this.genres, this.awards,
        this.pubCo, this.lastPubCollection);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Poet)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Poet poet = (Poet) o;
    return pubCo.equals(poet.pubCo) &&
        lastPubCollection.equals(poet.lastPubCollection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), pubCo, lastPubCollection);
  }

  @Override
  public String toString() {
    return "Poet{" +
        "pubCo='" + pubCo + '\'' +
        ", lastPubCollection='" + lastPubCollection + '\'' +
        ", name=" + name +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }

  public String getPubCo() {
    return pubCo;
  }

  public String getLastPubCollection() {
    return lastPubCollection;
  }
}
