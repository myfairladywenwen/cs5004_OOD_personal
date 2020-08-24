package problem1;

public class Painter extends AbstractGraphical{

  public Painter(Name name, Integer age, String[] genres, String[] awards,
      String[] exhibits) throws ExceedAgeLimitException {
    super(name, age, genres, awards, exhibits);
  }
  public AbstractArtist receiveAwards(String award)throws ExceedAgeLimitException {
    updateAwards(award);
    return new Painter(this.name, this.age, this.genres, this.awards, this.exhibits);
  }
}
