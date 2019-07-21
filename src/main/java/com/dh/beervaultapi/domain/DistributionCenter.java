package com.dh.beervaultapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DistributionCenter {
    private String id;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
}
