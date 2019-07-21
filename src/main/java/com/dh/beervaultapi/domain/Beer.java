package com.dh.beervaultapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Beer {
    private String id;
    private String name;
    private Float rating;
    private String image;
    private Brewery brewery;
}
