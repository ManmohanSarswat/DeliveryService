package com.cts.deliveryservice.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    private String line1;
    private String line2;
    private String city;
    private String state;

}