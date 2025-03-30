package com.example.ordermanagement;

public class DiscountService {
    /**
     * Tính chiết khấu cho đơn hàng:
     * Nếu số tiền đơn hàng >= 500 thì giảm 10%,
     * ngược lại không giảm.
     */
    public double calculateDiscount(Order order) {
        if (order.getAmount() >= 500) {
            return order.getAmount() * 0.10;
        }
        return 0.0;
    }
}
