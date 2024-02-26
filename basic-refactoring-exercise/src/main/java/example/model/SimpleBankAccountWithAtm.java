package example.model;

import example.model.balance.BalanceLogic;
import example.model.balance.SimpleBalanceLogic;
import example.model.fee.FeeLogic;
import example.model.fee.SimpleFeeLogic;

public class SimpleBankAccountWithAtm implements BankAccount {
    private final AccountHolder holder;
    private final BalanceLogic balanceLogic;
    private final FeeLogic feeLogic;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balanceLogic = new SimpleBalanceLogic(balance);
        this.feeLogic = new SimpleFeeLogic();
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
    public void deposit(int userID, double amount) {
        if (!this.holder.userEqual(userID)) return;
        this.balanceLogic.deposit(amount);
        this.feeLogic.payingFee(this.balanceLogic);
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (!this.holder.userEqual(userID) || !this.balanceLogic.canWithdraw(amount)) return;
        this.balanceLogic.withdraw(amount);
        this.feeLogic.payingFee(this.balanceLogic);
    }
}
