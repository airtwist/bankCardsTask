package org.example;

import java.math.BigDecimal;

public class FlyingMilesDebitCard extends DebitCard{
    private BigDecimal milesBalance = BigDecimal.ZERO;

    public FlyingMilesDebitCard(BigDecimal balance) {
        super(balance);
    }

    @Override
    void deposit(BigDecimal amount) {
        super.deposit(amount);
    }

    @Override
    boolean payment(BigDecimal amount) {
        if(super.payment(amount)){
            addMiles(amount);
            return true;
        } return false;
    }

    @Override
    void getBalanceInfo() {
        super.getBalanceInfo();
        System.out.println(this.milesBalance);
    }
    void addMiles(BigDecimal amount) {
        this.milesBalance = this.milesBalance.add(amount.divide(BigDecimal.valueOf(100)));
    }
}
