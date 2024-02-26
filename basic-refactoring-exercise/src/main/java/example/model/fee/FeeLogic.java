package example.model.fee;

import example.model.balance.BalanceLogic;

public interface FeeLogic {

    double fee();

    void payingFee(BalanceLogic balanceLogic);
}
