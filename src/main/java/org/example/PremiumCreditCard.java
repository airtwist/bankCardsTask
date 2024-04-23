package org.example;

import java.math.BigDecimal;

public class PremiumCreditCard extends CreditCard {
    final private BigDecimal cashBackPercentage;
    final private BigDecimal depositSavingPercentage;
    final private BigDecimal bonusPointsPercentage;
    private BigDecimal bonusBalance = BigDecimal.ZERO;

    public PremiumCreditCard(BigDecimal creditLimit, BigDecimal creditBalance,
                             BigDecimal balance, BigDecimal cashBackPercentage,
                             BigDecimal depositBonusPercentage, BigDecimal bonus) {
        super(creditLimit, creditBalance, balance);
        this.cashBackPercentage = cashBackPercentage;
        this.depositSavingPercentage = depositBonusPercentage;
        this.bonusPointsPercentage = bonus;
    }

    @Override
    void deposit(BigDecimal amount) {
        super.deposit(amount);
        if (creditBalance.compareTo(creditLimit)<0){
            addCreditBalance(addSavingsToBalance(amount));
        } else addBalance(addSavingsToBalance(amount));
    }

    @Override
    boolean payment(BigDecimal amount) {
        if(super.payment(amount)){
            addBalance(addCashBackToBalance(amount));
            addBonusPoints(amount);
            return true;
        } else return false;

    }
    BigDecimal addCashBackToBalance(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(5000)) >= 0) {
            return amount.multiply(cashBackPercentage);
        } else return BigDecimal.ZERO;
    }

    BigDecimal addSavingsToBalance(BigDecimal amount) {
        return amount.multiply(depositSavingPercentage);
    }

    void addBonusPoints(BigDecimal amount) {
        this.bonusBalance = this.bonusBalance.add(amount.multiply(bonusPointsPercentage));
    }

    @Override
    void getBalanceInfo() {
        super.getBalanceInfo();
        System.out.println(bonusBalance);
    }
}
