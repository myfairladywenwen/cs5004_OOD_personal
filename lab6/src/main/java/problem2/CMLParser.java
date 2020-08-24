package problem2;

public class CMLParser {
  private static final String INSTALL = "install";
  private static final String UNINSTALL = "uninstall";
  private static final String UPDATE = "update";
  private static final String WARNINGFlag = "-q";
  private static final String VERBOSEFLAG = "-v";
  private static final String DEBUGFLAG = "-d";
  private String operation;
  private String formula;
  private String warningsFlag = null;
  private String verboseFlag = null;
  private String debugFlag = null;

  public CMLParser(String[] args) throws IllegalArgumentException, InvalidArgumentsException {
    this.processArgs(args);
  }

  private void processArgs(String[] args) throws IllegalArgumentException, InvalidArgumentsException{
    if ((checkArgLen(args))) {
      throw new IllegalArgumentException("More than 5 arguments provided.");
    }

    if (checkOperation(args) < 0){
      throw new InvalidArgumentsException("No operation argument provided.");
    }
    this.operation = args[checkOperation(args)];

    if (checkFormula(args) < 0){
      throw new InvalidArgumentsException("No formula argument provided.");
    }
    this.formula = args[checkFormula(args)];

    if (checkWarningFlag(args)){
      this.warningsFlag = WARNINGFlag;
    }
    if (checkVerboseFlag(args)){
      this.verboseFlag = VERBOSEFLAG;
    }
    if (checkDebugFlag(args)){
      this.debugFlag = DEBUGFLAG;
    }
  }
  /**
   * Return true if there are more than 5 arguments
   * @param args
   * @return
   */
  private boolean checkArgLen(String[] args){
    return args.length > 6;
  }

  /**
   * Check whether the input arguments have the operation argument
   * @param args
   * @return
   */
  private int checkOperation(String[] args){
    for (int i = 1; i < args.length; i++){
      if (args[i].equals(INSTALL) || args[i].equals(UNINSTALL) || args[i].equals(UPDATE)){
        return i;
      }
    }
    return -1;
  }

  /**
   * Check whether the input arguments have the formula argument
   * @param args
   * @return
   */
  private int checkFormula(String[] args){
    for (int i = 1; i < args.length; i++){
      if (!args[i].equals(INSTALL) &&(!args[i].equals(INSTALL)) && (!args[i].equals(INSTALL))
          && !args[i].equals(WARNINGFlag) && (!args[i].equals(VERBOSEFLAG))
          && (!args[i].equals(DEBUGFLAG))){
        return i;
      }
    }
    return -1;
  }

  private boolean checkWarningFlag(String[] args){
    for (String s : args){
      if (s.equals(WARNINGFlag)){
        return true;
      }
    }
    return false;
  }
  private boolean checkVerboseFlag(String[] args){
    for (String s : args){
      if (s.equals(VERBOSEFLAG)){
        return true;
      }
    }
    return false;
  }
  private boolean checkDebugFlag(String[] args){
    for (String s : args){
      if (s.equals(DEBUGFLAG)){
        return true;
      }
    }
    return false;
  }

  public String getOperation() {
    return operation;
  }

  public String getFormula() {
    return formula;
  }

  public String getWarningsFlag() {
    return warningsFlag;
  }

  public String getVerboseFlag() {
    return verboseFlag;
  }

  public String getDebugFlag() {
    return debugFlag;
  }
}
