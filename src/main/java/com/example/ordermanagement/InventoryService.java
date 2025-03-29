package com.example.ordermanagement;

public class InventoryService {
    // Giả lập kiểm tra kho: đơn hàng có số tiền dưới 10,000 là đủ hàng
    public boolean checkInventory(Order order) {
        return order.getAmount() < 10000;
    }

    // Giả lập cập nhật kho sau khi thanh toán thành công
    public void updateInventory(Order order) {
        System.out.println("Inventory updated for order " + order.getOrderId());
    }
}
