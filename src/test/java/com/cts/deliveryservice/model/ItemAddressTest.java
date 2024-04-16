package com.cts.deliveryservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemAddressTest {

    private ItemAddress itemAddress;
    private Item item;
    private Address address;

    @BeforeEach
    public void setUp() {
        itemAddress = new ItemAddress();
        item = new Item();
        address = new Address();
    }

    @Test
    public void testItem() {
        itemAddress.setItem(item);
        assertEquals(item, itemAddress.getItem());
    }

    @Test
    public void testAddress() {
        itemAddress.setAddress(address);
        assertEquals(address, itemAddress.getAddress());
    }
}