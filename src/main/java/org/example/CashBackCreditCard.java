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
        BigDecimal sumOfBalances = getBalance().add(creditBalance);
        if (getBalance().compareTo(amount) >= 0) {
            subtractBalance(amount);
            addBalance(cashBack(amount));
            return true;
        } else if (sumOfBalances.compareTo(amount) >= 0) {
            subtractBalance(amount);
            creditBalance = creditBalance.add(getBalance());
            addBalance(getBalance().abs());
            creditBalance = creditBalance.add(cashBack(amount));
            return true;
        } else return false;
    }

    BigDecimal cashBack(BigDecimal amount) {
        if (amount.compareTo(cashBackThreshold) >= 0) {
            return amount.multiply(cashBackPercentage);
        } else return BigDecimal.ZERO;
    }

    @Override
    void getBalanceInfo() {
        super.getBalanceInfo();
    }
}
