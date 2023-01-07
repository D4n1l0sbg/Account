package model.entities;

import model.exception.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void Deposit(Double amount){
        this.balance = amount;
    }
    public void WithDraw(Double amount) throws DomainException {
        if(amount > balance){
            throw new DomainException("Not enough balance");
        }
        if(amount > withdrawLimit){
            throw new DomainException("The amount exceeds withdraw limit");
        }
        balance -= amount;
    }
    @Override
    public String toString(){
        return
                        "New Balance: "
                        +String.format("%.2f", getBalance());
    }
}
