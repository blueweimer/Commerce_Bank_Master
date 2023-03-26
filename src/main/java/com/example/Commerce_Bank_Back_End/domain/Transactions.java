package com.example.Commerce_Bank_Back_End.domain;

import java.util.Date;

public class Transactions {
    Integer t_id;
    Integer u_id;
    Double balance;
    Double amount;
    String type;
    Double savings_goal;
    Date date;

    public Transactions(Integer t_id, Integer u_id, Double balance, Double amount, String type, Double savings_goal, Date date) {
        this.t_id = t_id;
        this.u_id = u_id;
        this.balance = balance;
        this.amount = amount;
        this.type = type;
        this.savings_goal = savings_goal;
        this.date = date;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSavings_goal() {
        return savings_goal;
    }

    public void setSavings_goal(Double savings_goal) {
        this.savings_goal = savings_goal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
