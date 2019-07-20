package com.dh.beervaultapi.dao;

import com.dh.beervaultapi.domain.Beer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Slf4j
public class BeerDAO {

    private List<Beer> beerList;

    public List<Beer> getBeers(){
        return this.beerList;
    }

    public Beer getBeerById( String id ){
        log.debug( "Getting Beer by Id {}", id );
        return beerList.stream().filter( beer -> id.equals(beer.getId())).findAny().orElse(null);
    }
}
