package com.cts.deliveryservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    private Item item;

    @BeforeEach
    public void setUp() {
        item = new Item();
    }

    @Test
    public void testName() {
        String name = "Item1";
        item.setName(name);
        assertEquals(name, item.getName());
    }

    @Test
    public void testPrice() {
        double price = 19.99;
        item.setPrice(price);
        assertEquals(price, item.getPrice());
    }

    @Test
    public void testQuantity() {
        int quantity = 5;
        item.setQuantity(quantity);
        assertEquals(quantity, item.getQuantity());
    }
}