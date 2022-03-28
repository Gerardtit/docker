package com.automation.rest.cart.model;

import java.util.List;

public class GetOrdersResponse {
    private int orderCount;
    private List<Order> currentOrders;
    private List<Order> pastOrders;

    public long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int value) {
        this.orderCount = value;
    }

    public List<Order> getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(List<Order> value) {
        this.currentOrders = value;
    }

    public List<Order> getPastOrders() {
        return pastOrders;
    }

    public void setPastOrders(List<Order> value) {
        this.pastOrders = value;
    }

    @Override
    public String toString() {
        return "GetCartItemsResponse{" +
                "orderCount='" + orderCount + '\'' +
                ", currentOrders=" + currentOrders +
                ", pastOrders=" + pastOrders +
                '}';
    }
}
