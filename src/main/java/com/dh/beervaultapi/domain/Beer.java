package com.dh.beervaultapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Beer {
    private String id;
    private String name;
    private String image;
}
