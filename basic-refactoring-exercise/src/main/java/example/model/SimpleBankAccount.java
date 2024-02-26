package example.model;

import example.model.balance.BalanceLogic;
import example.model.balance.SimpleBalanceLogic;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    private final BalanceLogic balanceLogic;
    private final AccountHolder holder;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balanceLogic = new SimpleBalanceLogic(balance);
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balanceLogic.balance();
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (this.holder.userEqual(userID)) return;
        this.balanceLogic.deposit(amount);
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (!this.holder.userEqual(userID) || !this.balanceLogic.canWithdraw(amount)) return;
        this.balanceLogic.withdraw(amount);

    }
}
