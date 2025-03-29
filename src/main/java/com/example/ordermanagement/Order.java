package com.example.ordermanagement;

public class Order {
    private int orderId;
    private double amount;
    private boolean paid;

    public Order(int orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.paid = false;
    }
    
    public int getOrderId() {
        return orderId;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public boolean isPaid() {
        return paid;
    }
    
    public void markAsPaid() {
        this.paid = true;
    }
}
