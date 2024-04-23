package org.example;


import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        PremiumCreditCard creditCard = new PremiumCreditCard(BigDecimal.valueOf(10000),
                BigDecimal.valueOf(0),BigDecimal.valueOf(0),BigDecimal.valueOf(0.01),
                BigDecimal.valueOf(0.005),BigDecimal.valueOf(0.01));
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

        FlyingMilesDebitCard debitCard = new FlyingMilesDebitCard(BigDecimal.ZERO);
        debitCard.deposit(BigDecimal.valueOf(10000));
        debitCard.getBalanceInfo();
        debitCard.payment(BigDecimal.valueOf(5000));
        debitCard.getBalanceInfo();


    }
}