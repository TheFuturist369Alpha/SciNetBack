package com.jalvis.SciNet.dtos;

public class PaymentInfo {
    private int amount;
    private String currrency;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrrency() {
        return currrency;
    }

    public void setCurrrency(String currrency) {
        this.currrency = currrency;
    }
}
