package com.example.ordermanagement;

public class OrderService {
    private PaymentService paymentService;
    private InventoryService inventoryService;

    public OrderService(PaymentService paymentService, InventoryService inventoryService) {
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
    }

    // Xử lý đơn hàng: kiểm tra kho, xử lý thanh toán, cập nhật kho nếu thanh toán thành công
    public boolean processOrder(Order order) {
        if (!inventoryService.checkInventory(order)) {
            return false;
        }
        boolean paymentSuccess = paymentService.processPayment(order.getAmount());
        if (paymentSuccess) {
            order.markAsPaid();
            inventoryService.updateInventory(order);
            return true;
        } else {
            return false;
        }
    }
}
