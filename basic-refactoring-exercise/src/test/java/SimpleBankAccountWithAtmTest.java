import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest {
    private static final double INITIALIZE_BALANCE = 0.0d;
    private static final double DEFAULT_FEE = 1.0d;
    private static final double DEPOSIT_100 = 100.0d;
    private static final double DEPOSIT_50 = 50.0d;
    private static final double DEPOSIT_70 = 70.0d;
    private static final int ID_USER = 1;
    private static final int WRONG_ID_USER = 2;

    private AccountHolder accountHolder;
    private BankAccount bankAccount;


    @BeforeEach
    void beforeEach() {
        this.accountHolder = new AccountHolder("Manuel", "Buizo", ID_USER);
        this.bankAccount = new SimpleBankAccountWithAtm(this.accountHolder, INITIALIZE_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIALIZE_BALANCE, this.bankAccount.getBalance());
    }


    @Test
    void testDeposit() {
        this.bankAccount.deposit(this.accountHolder.getId(), DEPOSIT_100);
        assertEquals(DEPOSIT_100 - DEFAULT_FEE, this.bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        this.bankAccount.deposit(this.accountHolder.getId(), DEPOSIT_100);
        this.bankAccount.deposit(WRONG_ID_USER, DEPOSIT_50);
        assertEquals(DEPOSIT_100 - DEFAULT_FEE, this.bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        this.bankAccount.deposit(this.accountHolder.getId(), DEPOSIT_100);
        this.bankAccount.withdraw(this.accountHolder.getId(), DEPOSIT_70);
        assertEquals(DEPOSIT_100 - DEPOSIT_70 - DEFAULT_FEE, this.bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        this.bankAccount.deposit(this.accountHolder.getId(), DEPOSIT_100);
        this.bankAccount.withdraw(WRONG_ID_USER, DEPOSIT_70);
        assertEquals(DEPOSIT_100 - DEFAULT_FEE, this.bankAccount.getBalance());
    }


}
