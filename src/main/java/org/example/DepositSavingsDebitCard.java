package org.example;

import java.math.BigDecimal;

public class DepositSavingsDebitCard extends DebitCard {
    private final BigDecimal savingsBonusPercentage;

    public DepositSavingsDebitCard(BigDecimal balance, BigDecimal savingsBonusPercentage) {
        super(balance);
        this.savingsBonusPercentage = savingsBonusPercentage;
    }

    @Override
    boolean payment(BigDecimal amount) {
        if (getBalance().compareTo(amount) < 0) {
            return false;
        } else {
            subtractBalance(amount);
            addBonusToBalance(amount);
            return true;
        }
    }

    @Override
    void deposit(BigDecimal amount) {
        super.deposit(amount);
    }

    @Override
    void getBalanceInfo() {
        super.getBalanceInfo();
    }

    void addBonusToBalance(BigDecimal amount) {
        addBalance(amount.multiply(savingsBonusPercentage));
    }

}
