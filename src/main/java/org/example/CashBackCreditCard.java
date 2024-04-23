package org.example;

import java.math.BigDecimal;

public class CashBackCreditCard extends CreditCard {
    final private BigDecimal cashBackPercentage = BigDecimal.valueOf(0.005);
    final private BigDecimal cashBackThreshold = BigDecimal.valueOf(5000);

    public CashBackCreditCard(BigDecimal creditLimit, BigDecimal creditBalance, BigDecimal balance) {
        super(creditLimit, creditBalance, balance);
    }

    @Override
    void deposit(BigDecimal amount) {
        super.deposit(amount);
    }

    @Override
    boolean payment(BigDecimal amount) {
        if (super.payment(amount)) {
            if (creditBalance.compareTo(creditLimit) < 0) {
                creditBalance = creditBalance.add(addCashBackToBalance(amount));
            } else {
                addBalance(addCashBackToBalance(amount));
            }
            return true;
        } else return false;
    }

    BigDecimal addCashBackToBalance(BigDecimal amount) {
        if (amount.compareTo(cashBackThreshold) >= 0) {
            return amount.multiply(cashBackPercentage);
        } else return BigDecimal.ZERO;
    }

}