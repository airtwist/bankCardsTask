package org.example;

import java.math.BigDecimal;

public class CreditCard extends BankCard {
    protected BigDecimal creditLimit;
    protected BigDecimal creditBalance;

    public CreditCard(BigDecimal creditLimit, BigDecimal creditBalance, BigDecimal balance) {
        super(balance);
        this.creditLimit = creditLimit;
        this.creditBalance = creditBalance;
    }


    @Override
    void deposit(BigDecimal amount) {
        BigDecimal partialAmount;
        if (creditBalance.compareTo(creditLimit) < 0) {
            creditBalance = creditBalance.add(amount);
            if (creditBalance.compareTo(creditLimit) > 0) {
                partialAmount = creditBalance.subtract(creditLimit);
                addBalance(partialAmount);
                creditBalance = creditLimit;
            }
        } else {
            addBalance(amount);
        }
    }


    @Override
    boolean payment(BigDecimal amount) {
        BigDecimal sumOfBalances = getBalance().add(creditBalance);
        if (getBalance().compareTo(amount) >= 0) {
            subtractBalance(amount);
            return true;
        } else if (sumOfBalances.compareTo(amount) >= 0) {
            subtractBalance(amount);
            creditBalance = creditBalance.add(getBalance());
            addBalance(getBalance().abs());
            return true;
        } else return false;
    }

    @Override
    void getBalanceInfo() {
        System.out.println("---------");
        System.out.println(creditBalance);
        System.out.println(getBalance());
    }

    protected BigDecimal getCreditBalance() {
        return creditBalance;
    }
    protected BigDecimal getCreditLimit(){
        return creditLimit;
    }
    protected void addCreditBalance(BigDecimal amount) {
        this.creditBalance = this.creditBalance.add(amount);
    }
}
