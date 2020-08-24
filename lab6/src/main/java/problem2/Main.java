package problem2;

public class Main {
  public static void main(String[] args){
    try {
      CMLParser cmlp = new CMLParser(args);
      // till now, the cmlp has been constructed with proper arguments
      HomebakeProcessor hp = new HomebakeProcessor(cmlp.getOperation(), cmlp.getFormula(), cmlp.getWarningsFlag(),
          cmlp.getVerboseFlag(), cmlp.getDebugFlag());
    } catch(IllegalArgumentException | InvalidArgumentsException e){
      e.getMessage();
    }

  }

}
