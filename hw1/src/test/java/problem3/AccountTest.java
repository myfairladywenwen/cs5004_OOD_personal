package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account testAccount;
    String firstName = "wen";
    String lastName = "xie";
    Person testAccountHolder = new Person(firstName, lastName);
    int dollar = 10;
    int cent = 20;
    Amount testAmount = new Amount(dollar, cent);

    @Before
    public void setUp() throws Exception {
        testAccount = new Account(testAccountHolder, testAmount);
    }

    @Test
    public void getAccountHolder() {
        assertEquals(testAccountHolder, testAccount.getAccountHolder());
    }

    @Test
    public void getAmount() {
        assertEquals(testAmount, testAccount.getAmount());
    }

    @Test
    public void deposit() {
        Amount depositAmount = new Amount(20, 50);
        Account expectedAccount = new Account(new Person(firstName, lastName),
                                                new Amount(30,70));
        Account resultAccount = testAccount.deposit(depositAmount);
        Account resultAccountWrong = new Account(new Person(firstName, lastName),
                                                    new Amount(40, 10));
        assertTrue(expectedAccount.accountEquals(resultAccount));
        assertFalse(expectedAccount.accountEquals(resultAccountWrong));
    }

    @Test
    public void withdraw() {
        Amount withdrawAmount = new Amount(2, 50);
        Account expectedAccount = new Account(new Person(firstName, lastName),
                new Amount(7,70));
        Account resultAccount = testAccount.withdraw(withdrawAmount);
        Account resultAccountWrong = new Account(new Person(firstName, lastName),
                new Amount(40, 10));
        assertTrue(expectedAccount.accountEquals(resultAccount));
        assertFalse(expectedAccount.accountEquals(resultAccountWrong));
    }

    @Test
    public void accountEquals() {
        Account account1 = new Account(new Person(firstName, lastName), new Amount(10,20));
        Account account2 = new Account(new Person(firstName, lastName), new Amount(10,20));
        assertTrue(account1.accountEquals(account2));
        Account account3 = new Account(new Person(firstName, lastName), new Amount(20,20));
        assertFalse(account1.accountEquals(account3));
        Account account4 = new Account(new Person(firstName, lastName), new Amount(10,30));
        assertFalse(account1.accountEquals(account4));
        Account account5 = new Account(new Person(firstName, lastName), new Amount(20,30));
        assertFalse(account1.accountEquals(account5));
        Account account6 = new Account(new Person(firstName + firstName, lastName), new Amount(20,30));
        assertFalse(account1.accountEquals(account6));
        Account account7 = new Account(new Person(firstName, lastName + lastName), new Amount(20,30));
        assertFalse(account1.accountEquals(account7));
        Account account8 = new Account(new Person(firstName + firstName, lastName + lastName), new Amount(20,30));
        assertFalse(account1.accountEquals(account8));

    }
}