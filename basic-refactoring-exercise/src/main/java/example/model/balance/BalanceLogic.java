package example.model.balance;

public interface BalanceLogic {

    double balance();

    void deposit(double amount);
    void withdraw(double amount);
}
