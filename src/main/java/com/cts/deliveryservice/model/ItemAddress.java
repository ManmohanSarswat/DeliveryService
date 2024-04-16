package com.cts.deliveryservice.model;

import lombok.Data;

@Data
public class ItemAddress {
    private Item item;
    private Address address;
}
