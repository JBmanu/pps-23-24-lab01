package example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccount {
    private static final double FEE_DEFAULT = 1.;

    private double fee;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(holder, balance);
        this.fee = FEE_DEFAULT;
    }

    @Override
    public AccountHolder getHolder() {
        return super.getHolder();
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void deposit(int userID, double amount) {

    }

    @Override
    public void withdraw(int userID, double amount) {

    }
}
