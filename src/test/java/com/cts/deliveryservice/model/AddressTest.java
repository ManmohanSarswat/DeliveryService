package com.cts.deliveryservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {

    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address();
    }

    @Test
    public void testLine1() {
        String line1 = "123 Main St";
        address.setLine1(line1);
        assertEquals(line1, address.getLine1());
    }

    @Test
    public void testLine2() {
        String line2 = "Apt 4B";
        address.setLine2(line2);
        assertEquals(line2, address.getLine2());
    }

    @Test
    public void testCity() {
        String city = "New York";
        address.setCity(city);
        assertEquals(city, address.getCity());
    }

    @Test
    public void testState() {
        String state = "NY";
        address.setState(state);
        assertEquals(state, address.getState());
    }
}