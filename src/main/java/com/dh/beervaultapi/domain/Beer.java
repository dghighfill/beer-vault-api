package com.dh.beervaultapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Beer {
    private String id;
    private String name;
    private Float rating;
    private String image;

    // Do this so Jackson won't throw a cyclic reference
    @JsonIgnore
    private Brewery brewery;

}
