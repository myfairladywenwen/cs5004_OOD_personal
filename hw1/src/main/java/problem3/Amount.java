package problem3;

/**
 * Amount is an object that has a dollar and a cent.
 */
public final class Amount {
    private final int dollar;
    private final int cent;
    private static final int CENT_IN_DOLLAR = 100;

    /**
     * Constructor that creates a new Amount object with the specified dollar and cent.
     * @param dollar
     * @param cent
     */
    public Amount(int dollar, int cent) {
        if (dollar < 0 || cent < 0 || cent > 99){
            throw new IllegalArgumentException("invalid input");
        }
        this.dollar = dollar;
        this.cent = cent;
    }

    /**
     * Return dollar.
     * @return dollar
     */
    public int getDollar() {
        return dollar;
    }

    /**
     * Return cent.
     * @return cent
     */
    public int getCent() {
        return cent;
    }

    /**
     * Return the corresponding cent value of Amount.
     * @param
     * @return int
     */
    public int convertToCent(){
        return this.getCent() + this.getDollar() * CENT_IN_DOLLAR;
    }

    /**
     * Return the Amount of the passing in cents.
     * @param cents
     * @return Amount
     */
    public static Amount convertToAmount(int cents){
        int resultDollar = cents / CENT_IN_DOLLAR;
        int resultCent = cents % CENT_IN_DOLLAR;
        return new Amount(resultDollar, resultCent);
    }

    /**
     * Return true if the passing in Amount has the same value of the calling object,
     * otherwise return false.
     * @param anotherAmount
     * @return boolean
     */
    public boolean amountEquals(Amount anotherAmount){
        return (this.getDollar() == anotherAmount.getDollar() &&
                this.getCent() == anotherAmount.getCent());
    }
}
