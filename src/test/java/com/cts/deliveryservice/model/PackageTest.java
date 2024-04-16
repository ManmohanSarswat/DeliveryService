package com.cts.deliveryservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PackageTest {

    private Package aPackage;
    private List<Item> items;
    private Address address;

    @BeforeEach
    public void setUp() {
        aPackage = new Package();
        items = new ArrayList<>();
        address = new Address();
    }

    @Test
    public void testItems() {
        aPackage.setItems(items);
        assertEquals(items, aPackage.getItems());
    }

    @Test
    public void testAddress() {
        aPackage.setAddress(address);
        assertEquals(address, aPackage.getAddress());
    }
}
