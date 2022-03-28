package com.automation.rest.cart.model;

public class CardSavings {
    private String savingsCategoryId;

    private String savingsCategoryName;

    private Double savingsAmount;

    public String getSavingsCategoryId() {
        return savingsCategoryId;
    }

    public void setSavingsCategoryId(String savingsCategoryId) {
        this.savingsCategoryId = savingsCategoryId;
    }

    public String getSavingsCategoryName() {
        return savingsCategoryName;
    }

    public void setSavingsCategoryName(String savingsCategoryName) {
        this.savingsCategoryName = savingsCategoryName;
    }

    public Double getSavingsAmount() {
        return savingsAmount;
    }

    public void setSavingsAmount(Double savingsAmount) {
        this.savingsAmount = savingsAmount;
    }

    @Override
    public String toString() {
        return "CardSavings{" +
                "savingsCategoryId='" + savingsCategoryId + '\'' +
                ", savingsCategoryName='" + savingsCategoryName + '\'' +
                ", savingsAmount=" + savingsAmount +
                '}';
    }
}