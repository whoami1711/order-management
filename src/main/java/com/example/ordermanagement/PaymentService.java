package com.example.ordermanagement;

public class PaymentService {
    // Giả lập xử lý thanh toán: trả về true nếu số tiền lớn hơn 0
    public boolean processPayment(double amount) {
        return amount > 0;
    }
}
