package com.dh.beervaultapi.domain;

import lombok.Data;

import java.util.List;

@Data
public class Brewery {
    private String id;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
    private List<Beer> beers;

    public Brewery(String id, String name, String addressLine1, String addressLine2, String city, String state, String zip) {
        this.id = id;
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
