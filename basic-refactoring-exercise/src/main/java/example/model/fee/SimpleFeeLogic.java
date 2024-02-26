package example.model.fee;

import example.model.balance.BalanceLogic;

public class SimpleFeeLogic implements FeeLogic{
    private double fee;

    SimpleFeeLogic(){
        this.fee = 1.0d;
    }

    public double fee() {
        return this.fee;
    }

    @Override
    public void payingFee(BalanceLogic balanceLogic) {
        balanceLogic.withdraw(this.fee);
    }
}
