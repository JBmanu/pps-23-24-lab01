package example.model.fee;

import example.model.balance.BalanceLogic;

public class SimpleFeeLogic implements FeeLogic {
    private static final double DEFAULT_FEE = 1.0d;
    private final double fee;

    SimpleFeeLogic(double fee) {
        this.fee = fee;
    }
    SimpleFeeLogic() {
        this(DEFAULT_FEE);
    }

    @Override
    public double fee() {
        return this.fee;
    }

    @Override
    public void payingFee(BalanceLogic balanceLogic) {
        balanceLogic.withdraw(this.fee);
    }
}
