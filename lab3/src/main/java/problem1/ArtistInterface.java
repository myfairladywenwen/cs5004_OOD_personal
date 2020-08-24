package problem1;

interface ArtistInterface {
    AbstractArtist receiveAwards(String award)throws ExceedAgeLimitException;
    String toString();
    boolean equals(Object o);
    int hashCode();
    Name getName();
    Integer getAge();
    String[] getGenres();
    String[] getAwards();
}
