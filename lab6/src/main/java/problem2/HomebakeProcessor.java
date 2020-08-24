package problem2;

public class HomebakeProcessor {
  private String operation = null;
  private String formula = null;
  private String warningsFlag = null;
  private String verboseFlag = null;
  private String debugFlag = null;

  public HomebakeProcessor(String operation, String formula, String warningsFlag,
      String verboseFlag, String debugFlag) {
    this.operation = operation;
    this.formula = formula;
    this.warningsFlag = warningsFlag;
    this.verboseFlag = verboseFlag;
    this.debugFlag = debugFlag;
  }
}
