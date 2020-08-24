package problem1;

import java.util.Arrays;
import java.util.Objects;

public class Musician extends AbstractArtist {
  private String recordingCo;
  private String lastAlbum;

  public Musician(Name name, Integer age, String[] genres, String[] awards,
      String recordingCo, String lastAlbum) throws ExceedAgeLimitException {
    super(name, age, genres, awards);
    this.recordingCo = recordingCo;
    this.lastAlbum = lastAlbum;
  }

  public AbstractArtist receiveAwards(String award)throws ExceedAgeLimitException {
    updateAwards(award);
    return new Musician(this.name, this.age, this.genres, this.awards, this.recordingCo,
        this.lastAlbum);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Musician)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Musician musician = (Musician) o;
    return recordingCo.equals(musician.recordingCo) &&
        lastAlbum.equals(musician.lastAlbum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), recordingCo, lastAlbum);
  }

  @Override
  public String toString() {
    return "Musician{" +
        "recordingCo='" + recordingCo + '\'' +
        ", lastAlbum='" + lastAlbum + '\'' +
        ", name=" + name +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }

  public String getRecordingCo() {
    return recordingCo;
  }

  public String getLastAlbum() {
    return lastAlbum;
  }

}

