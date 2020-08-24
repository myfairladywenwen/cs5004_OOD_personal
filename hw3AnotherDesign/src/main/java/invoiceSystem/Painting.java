package invoiceSystem;

public class Painting extends Interior{
  private static final int TIME_S_M = 16;
  private static final int TIME_L = 24;


  public Painting(String address, Size size, boolean monthly, int preService, int numPets) {
    super(address, size, monthly, preService, numPets);
  }

  @Override
  protected int calTime(){
    switch (this.size){
      case LARGE:
        return TIME_L;
      default:  //default is small and med
        return TIME_S_M;
    }
  }

}
