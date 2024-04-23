package org.example;

import java.math.BigDecimal;

public abstract class BankCard {
    private BigDecimal balance;

    void deposit(BigDecimal amount) {
       addBalance(amount);
    }
    boolean payment(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            subtractBalance(amount);
            return true;
        } else return false;
    }
    void getBalanceInfo(){
        System.out.println("---------");
        System.out.println(balance);
    }

    public BankCard(BigDecimal balance) {
        this.balance = balance;
    }

    protected BigDecimal getBalance() {
        return balance;
    }

    
    protected void addBalance(BigDecimal balance) {
        this.balance = this.balance.add(balance);
    }
    protected void subtractBalance(BigDecimal balance) {
        this.balance = this.balance.subtract(balance);
    }

}
