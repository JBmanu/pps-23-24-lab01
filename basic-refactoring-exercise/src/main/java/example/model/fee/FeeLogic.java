package example.model.fee;

import example.model.balance.BalanceLogic;

public interface FeeLogic {
    void payingFee(BalanceLogic balance);
}
