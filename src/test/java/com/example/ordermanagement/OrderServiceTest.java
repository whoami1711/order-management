package com.example.ordermanagement;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceTest {
    private OrderService orderService;
    private PaymentService paymentService;
    private InventoryService inventoryService;

    @Before
    public void setUp() {
        paymentService = new PaymentService();
        inventoryService = new InventoryService();
        orderService = new OrderService(paymentService, inventoryService);
    }

    @Test
    public void testProcessOrderSuccessful() {
        Order order = new Order(1, 100.0);
        boolean result = orderService.processOrder(order);
        assertTrue(result);
        assertTrue(order.isPaid());
    }

    @Test
    public void testProcessOrderFailInventory() {
        // Đơn hàng với số tiền cao vượt quá ngưỡng kho (ví dụ 15,000)
        Order order = new Order(2, 15000.0);
        boolean result = orderService.processOrder(order);
        assertFalse(result);
        assertFalse(order.isPaid());
    }

    @Test
    public void testProcessOrderFailPayment() {
        // Thanh toán thất bại nếu số tiền <= 0
        Order order = new Order(3, 0.0);
        boolean result = orderService.processOrder(order);
        assertFalse(result);
        assertFalse(order.isPaid());
    }
}
