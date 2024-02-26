package example.model.balance;

public class SimpleBalanceLogic implements BalanceLogic {
    private static final double DEFAULT_BALANCE = 0.0d;
    private double balance;

    public SimpleBalanceLogic(double balance) {
        this.balance = balance;
    }
    public SimpleBalanceLogic() {
        this(DEFAULT_BALANCE);
    }


    @Override
    public double balance() {
        return this.balance;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }
    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    @Override
    public boolean canWithdraw(double amount) {
        return this.balance >= amount;
    }
}
