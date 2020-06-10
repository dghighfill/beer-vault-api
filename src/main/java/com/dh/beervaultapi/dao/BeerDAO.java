package com.dh.beervaultapi.dao;

import com.dh.beervaultapi.domain.Beer;
import com.dh.beervaultapi.domain.Brewery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Slf4j
public class BeerDAO {

    public Beer getBeerById( Brewery brewery, String id ){
        log.debug( "Getting Beer by Id {}", id );
        return brewery.getBeers().stream().filter( beer -> id.equals(beer.getId())).findAny().orElse(null);
    }

    public Beer createBeer( Brewery brewery, String name, Float rating, String image) {
        List<Beer> beerList = brewery.getBeers();
        Integer newIndex = Integer.valueOf( beerList.stream().reduce((first, second) -> second).orElse(null).getId()) + 1;
        Beer newBeer = new Beer(newIndex.toString(), name, rating, image, null);
        log.debug("Created Beer {}", newBeer.toString());
        beerList.add(newBeer);
        log.debug( "Created Beer {}", newBeer.getId() );
        return newBeer;
    }

    public Beer deleteBeer(Brewery brewery, String id) {
        log.debug("Deleting Beer by Id {}", id);
        Beer deletedBeer = this.getBeerById(brewery, id);
        brewery.getBeers().remove(deletedBeer);
        return deletedBeer;
    }
}
