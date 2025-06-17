package com.jalvis.SciNet.dtos;

public class PaymentInfo {
    private int amount;
    private String currency;
    private String receipt_email;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {

        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currrency) {
        this.currency = currrency;
    }

    public String getReceipt_email() {
        return receipt_email;
    }

    public void setReceipt_email(String receipt_email) {
        this.receipt_email = receipt_email;
    }
}
