package org.example;


import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        PremiumCreditCard creditCard = new PremiumCreditCard(BigDecimal.valueOf(10000), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(0.01), BigDecimal.valueOf(0.005), BigDecimal.valueOf(0.01));
        creditCard.deposit(BigDecimal.valueOf(10000));
        creditCard.getBalanceInfo();
        creditCard.deposit(BigDecimal.valueOf(5000));
        creditCard.getBalanceInfo();
        creditCard.payment(BigDecimal.valueOf(5000));
        creditCard.getBalanceInfo();
        creditCard.payment(BigDecimal.valueOf(3000));
        creditCard.getBalanceInfo();
        creditCard.deposit(BigDecimal.valueOf(2000));
        creditCard.getBalanceInfo();
        creditCard.deposit(BigDecimal.valueOf(2000));
        creditCard.getBalanceInfo();

        CashBackCreditCard cashBackCreditCard = new CashBackCreditCard(BigDecimal.valueOf(15000), BigDecimal.ZERO, BigDecimal.ZERO);
        cashBackCreditCard.deposit(BigDecimal.valueOf(15000));
        cashBackCreditCard.getBalanceInfo();
        cashBackCreditCard.deposit(BigDecimal.valueOf(5000));
        cashBackCreditCard.getBalanceInfo();
        cashBackCreditCard.payment(BigDecimal.valueOf(13000));
        cashBackCreditCard.getBalanceInfo();
        cashBackCreditCard.deposit(BigDecimal.valueOf(2000));
        cashBackCreditCard.getBalanceInfo();
        cashBackCreditCard.payment(BigDecimal.valueOf(6000));
        cashBackCreditCard.getBalanceInfo();
        cashBackCreditCard.deposit(BigDecimal.valueOf(20000));
        cashBackCreditCard.getBalanceInfo();

        FlyingMilesDebitCard debitCard = new FlyingMilesDebitCard(BigDecimal.ZERO);
        debitCard.deposit(BigDecimal.valueOf(10000));
        debitCard.getBalanceInfo();
        debitCard.payment(BigDecimal.valueOf(5000));
        debitCard.getBalanceInfo();

        DepositSavingsDebitCard savingsDebitCard = new DepositSavingsDebitCard(BigDecimal.ZERO, BigDecimal.valueOf(0.01));
        savingsDebitCard.deposit(BigDecimal.valueOf(10000));
        savingsDebitCard.getBalanceInfo();
        savingsDebitCard.payment(BigDecimal.valueOf(7000));
        savingsDebitCard.getBalanceInfo();

    }
}