package problem1;

public class Photographer extends AbstractGraphical{

  public Photographer(Name name, Integer age, String[] genres, String[] awards,
      String[] exhibits) throws ExceedAgeLimitException {
    super(name, age, genres, awards, exhibits);
  }
  public AbstractArtist receiveAwards(String award)throws ExceedAgeLimitException {
    updateAwards(award);
    return new Photographer(this.name, this.age, this.genres, this.awards, this.exhibits);
  }
}
