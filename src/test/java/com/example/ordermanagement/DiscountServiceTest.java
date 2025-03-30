package com.example.ordermanagement;

import static org.junit.Assert.*;
import org.junit.Test;

public class DiscountServiceTest {

    @Test
    public void testCalculateDiscountAboveThreshold() {
        Order order = new Order(4, 600.0);
        DiscountService discountService = new DiscountService();
        double discount = discountService.calculateDiscount(order);
        // 10% của 600 = 60
        assertEquals(60.0, discount, 0.001);
    }

    @Test
    public void testCalculateDiscountBelowThreshold() {
        Order order = new Order(5, 400.0);
        DiscountService discountService = new DiscountService();
        double discount = discountService.calculateDiscount(order);
        // Với số tiền dưới 500, chiết khấu là 0
        assertEquals(0.0, discount, 0.001);
    }
}
