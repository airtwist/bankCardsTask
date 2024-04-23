package org.example;

import java.math.BigDecimal;

public class DebitCard extends BankCard {


    public DebitCard(BigDecimal balance) {
        super(balance);

    }

    @Override
    void deposit(BigDecimal amount) {
        super.deposit(amount);
    }

    @Override
    boolean payment(BigDecimal amount) {
        if (getBalance().compareTo(amount) < 0) {
            return false;
        } else {
            subtractBalance(amount);
            return true;
        }
    }

    @Override
    void getBalanceInfo() {
        System.out.println("------");
        System.out.println(getBalance());
    }
}
