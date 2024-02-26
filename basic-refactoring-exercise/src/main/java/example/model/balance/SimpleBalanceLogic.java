package example.model.balance;

public class SimpleBalanceLogic implements BalanceLogic{

    private static double DEFAULT_BALANCE = 0.0d;
    private double balance;

    public SimpleBalanceLogic() {
        this.balance = DEFAULT_BALANCE;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }
}
