package problem1;

public class FilmMaker extends AbstractMedia {

  public FilmMaker(Name name, Integer age, String[] genres, String[] awards,
      String[] movies, String[] series, String[] multimedia) throws ExceedAgeLimitException {
    super(name, age, genres, awards, movies, series, multimedia);
  }

  public AbstractArtist receiveAwards(String award)throws ExceedAgeLimitException {
    updateAwards(award);
    return new FilmMaker(this.name, this.age, this.genres, this.awards, this.movies,
        this.series, this.multimedia);
  }
  }
