package com.dh.beervaultapi.dao;

import com.dh.beervaultapi.domain.Beer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class BeerDAO {

    List<Beer> beerList;

    public List<Beer> getBeers(){
        return this.beerList;
    }
}
