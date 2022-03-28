package com.automation.rest.cart.model;


import java.util.List;

public class WysiwygOrderSummary {
    private String totalItemQuantity;
    private double totalBasePrice;
    private double totalEstimatedPrice;
    private double totalEstimatedPriceWithTax;
    private String qualifyingDollarValue;
    private int uniqueItemsCount;
    private boolean hasRestrictedItems;
    private boolean hasItemsWithPromoExpiry;
    private boolean isCheckoutAllowed;
    private int totalOfferSavings;
    private int coaBalance;
    private int appliedPromoCount;
    private double totalSnapItemPrice;
    private double totalSnapItemPriceWithTax;
    private double totalNonSnapItemsPrice;
    private double totalNonSnapItemsPriceWithTax;
    private double actualTotalNonSnapItemsPrice;
    private double actualTotalSnapItemPrice;
    private List<CardSavings> cardSavings;

    public String getTotalItemQuantity() {
        return totalItemQuantity;
    }

    public void setTotalItemQuantity(String totalItemQuantity) {
        this.totalItemQuantity = totalItemQuantity;
    }

    public double getTotalBasePrice() {
        return totalBasePrice;
    }

    public void setTotalBasePrice(double totalBasePrice) {
        this.totalBasePrice = totalBasePrice;
    }

    public double getTotalEstimatedPrice() {
        return totalEstimatedPrice;
    }

    public void setTotalEstimatedPrice(double totalEstimatedPrice) {
        this.totalEstimatedPrice = totalEstimatedPrice;
    }

    public double getTotalEstimatedPriceWithTax() {
        return totalEstimatedPriceWithTax;
    }

    public void setTotalEstimatedPriceWithTax(double totalEstimatedPriceWithTax) {
        this.totalEstimatedPriceWithTax = totalEstimatedPriceWithTax;
    }

    public String getQualifyingDollarValue() {
        return qualifyingDollarValue;
    }

    public void setQualifyingDollarValue(String qualifyingDollarValue) {
        this.qualifyingDollarValue = qualifyingDollarValue;
    }

    public int getUniqueItemsCount() {
        return uniqueItemsCount;
    }

    public void setUniqueItemsCount(int uniqueItemsCount) {
        this.uniqueItemsCount = uniqueItemsCount;
    }

    public boolean isHasRestrictedItems() {
        return hasRestrictedItems;
    }

    public void setHasRestrictedItems(boolean hasRestrictedItems) {
        this.hasRestrictedItems = hasRestrictedItems;
    }

    public boolean isHasItemsWithPromoExpiry() {
        return hasItemsWithPromoExpiry;
    }

    public void setHasItemsWithPromoExpiry(boolean hasItemsWithPromoExpiry) {
        this.hasItemsWithPromoExpiry = hasItemsWithPromoExpiry;
    }

    public boolean isCheckoutAllowed() {
        return isCheckoutAllowed;
    }

    public void setCheckoutAllowed(boolean checkoutAllowed) {
        isCheckoutAllowed = checkoutAllowed;
    }

    public int getTotalOfferSavings() {
        return totalOfferSavings;
    }

    public void setTotalOfferSavings(int totalOfferSavings) {
        this.totalOfferSavings = totalOfferSavings;
    }

    public int getCoaBalance() {
        return coaBalance;
    }

    public void setCoaBalance(int coaBalance) {
        this.coaBalance = coaBalance;
    }

    public int getAppliedPromoCount() {
        return appliedPromoCount;
    }

    public void setAppliedPromoCount(int appliedPromoCount) {
        this.appliedPromoCount = appliedPromoCount;
    }

    public double getTotalSnapItemPrice() {
        return totalSnapItemPrice;
    }

    public void setTotalSnapItemPrice(double totalSnapItemPrice) {
        this.totalSnapItemPrice = totalSnapItemPrice;
    }

    public double getTotalSnapItemPriceWithTax() {
        return totalSnapItemPriceWithTax;
    }

    public void setTotalSnapItemPriceWithTax(double totalSnapItemPriceWithTax) {
        this.totalSnapItemPriceWithTax = totalSnapItemPriceWithTax;
    }

    public double getTotalNonSnapItemsPrice() {
        return totalNonSnapItemsPrice;
    }

    public void setTotalNonSnapItemsPrice(double totalNonSnapItemsPrice) {
        this.totalNonSnapItemsPrice = totalNonSnapItemsPrice;
    }

    public double getTotalNonSnapItemsPriceWithTax() {
        return totalNonSnapItemsPriceWithTax;
    }

    public void setTotalNonSnapItemsPriceWithTax(double totalNonSnapItemsPriceWithTax) {
        this.totalNonSnapItemsPriceWithTax = totalNonSnapItemsPriceWithTax;
    }

    public double getActualTotalNonSnapItemsPrice() {
        return actualTotalNonSnapItemsPrice;
    }

    public void setActualTotalNonSnapItemsPrice(double actualTotalNonSnapItemsPrice) {
        this.actualTotalNonSnapItemsPrice = actualTotalNonSnapItemsPrice;
    }

    public double getActualTotalSnapItemPrice() {
        return actualTotalSnapItemPrice;
    }

    public void setActualTotalSnapItemPrice(double actualTotalSnapItemPrice) {
        this.actualTotalSnapItemPrice = actualTotalSnapItemPrice;
    }

    public List<CardSavings> getCardSavings() {
        return cardSavings;
    }

    public void setCardSavings(List<CardSavings> cardSavings) {
        this.cardSavings = cardSavings;
    }

    @Override
    public String toString() {
        return "WysiwygOrderSummaryEditCart{" +
                "totalItemQuantity='" + totalItemQuantity + '\'' +
                ", totalBasePrice=" + totalBasePrice +
                ", totalEstimatedPrice=" + totalEstimatedPrice +
                ", totalEstimatedPriceWithTax=" + totalEstimatedPriceWithTax +
                ", qualifyingDollarValue='" + qualifyingDollarValue + '\'' +
                ", uniqueItemsCount=" + uniqueItemsCount +
                ", hasRestrictedItems=" + hasRestrictedItems +
                ", hasItemsWithPromoExpiry=" + hasItemsWithPromoExpiry +
                ", isCheckoutAllowed=" + isCheckoutAllowed +
                ", totalOfferSavings=" + totalOfferSavings +
                ", coaBalance=" + coaBalance +
                ", appliedPromoCount=" + appliedPromoCount +
                ", totalSnapItemPrice=" + totalSnapItemPrice +
                ", totalSnapItemPriceWithTax=" + totalSnapItemPriceWithTax +
                ", totalNonSnapItemsPrice=" + totalNonSnapItemsPrice +
                ", totalNonSnapItemsPriceWithTax=" + totalNonSnapItemsPriceWithTax +
                ", actualTotalNonSnapItemsPrice=" + actualTotalNonSnapItemsPrice +
                ", actualTotalSnapItemPrice=" + actualTotalSnapItemPrice +
                ", cardSavings=" + cardSavings +
                '}';
    }
}
