package com.dh.beervaultapi.dao;

import com.dh.beervaultapi.domain.Beer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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

    public Beer createBeer(String name, Float rating, String image) {
        Integer newIndex = Integer.valueOf(this.beerList.stream().reduce((first, second) -> second).orElse(null).getId()) + 1;
        Beer newBeer = new Beer(newIndex.toString(), name, rating, image, null);
        log.debug("Created Beer {}", newBeer.toString());
        this.beerList.add(newBeer);
        return newBeer;
    }

    public Beer deleteBeer(String id) {
        log.debug("Deleting Beer by Id {}", id);
        Beer deletedBeer = this.getBeerById(id);
        this.beerList.remove(deletedBeer);
        return deletedBeer;
    }
}
