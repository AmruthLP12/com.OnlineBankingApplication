// src/com/banking/model/Account.java
package com.banking.model;

public class Account {
    private int id;
    private String account_number;
    private String account_type;
    private double balance;
    private int customer_id;

    public Account(int id, String account_number, String account_type, double balance, int customer_id) {
        this.id = id;
        this.account_number = account_number;
        this.account_type = account_type;
        this.balance = balance;
        this.customer_id = customer_id;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getaccount_number() {
        return account_number;
    }

    public void setaccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getaccount_type() {
        return account_type;
    }

    public void setaccount_type(String account_type) {
        this.account_type = account_type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getcustomer_id() {
        return customer_id;
    }

    public void setcustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account_number='" + account_number + '\'' +
                ", account_type='" + account_type + '\'' +
                ", balance=" + balance +
                ", customer_id=" + customer_id +
                '}';
    }
}
