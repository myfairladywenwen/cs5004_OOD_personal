package problem3;

/**
 * Account is an object that has an accountHolder and an amount.
 */
public final class Account {

    private final Person accountHolder;
    private final Amount amount;

    /**
     * Constructor that creates a new Amount object with the specified accountHolder and amount.
     * @param accountHolder
     * @param amount
     */
    public Account(Person accountHolder, Amount amount) {
        this.accountHolder = accountHolder;
        this.amount = amount;
    }

    /**
     * Return accountHolder.
     * @return accountHolder
     */
    public Person getAccountHolder() {
        return accountHolder;
    }

    /**
     * Return amount.
     * @return amount
     */
    public Amount getAmount() {
        return amount;
    }

    /**
     * Return a new Account object with a new Amount.
     * @param depositMoney
     * @return Account
     */
    public Account deposit(Amount depositMoney){
        int totalCents = depositMoney.convertToCent() +
                        this.getAmount().convertToCent();
        Amount newAmount = Amount.convertToAmount(totalCents);
        return new Account(getAccountHolder(), newAmount);
    }

    /**
     * Return a new Account object with a new Amount.
     * @param withdrawMoney
     * @return
     */
    public Account withdraw(Amount withdrawMoney){
        int totalCents = this.getAmount().convertToCent() -
                            withdrawMoney.convertToCent();
        Amount newAmount = Amount.convertToAmount(totalCents);
        return new Account(getAccountHolder(), newAmount);
    }

    /**
     * Return true if the passing in Account has the same Person value and same amount value of the calling object,
     * otherwise return false.
     * @param anotherAccount
     * @return boolean
     */
    public boolean accountEquals(Account anotherAccount){
        return this.getAccountHolder().personEquals(anotherAccount.getAccountHolder()) &&
                this.getAmount().amountEquals(anotherAccount.getAmount());
    }

}
