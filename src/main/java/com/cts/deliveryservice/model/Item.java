package com.cts.deliveryservice.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Item {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private double total;

}
