package com.dh.beervaultapi.controller;

import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.dao.BreweryDAO;
import com.dh.beervaultapi.domain.Beer;
import com.dh.beervaultapi.domain.Brewery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class MainController {

    @Value( "${application.favorite.name}" )
    private String favoriteBeer;

    @Value( "${application.favorite.brewery}" )
    private String favoriteBrewery;

    private BreweryDAO breweryDao;
    private BeerDAO beerDao;

    public MainController( BreweryDAO breweryDao) {
        this.breweryDao = breweryDao;
    }

    @GetMapping("/breweries")
    public List<Brewery> getBreweries() {
        log.debug( "Getting breweries" );
        return this.breweryDao.getBreweries();
    }

    @GetMapping("/breweries/{breweryId}")
    public Brewery getBreweryById( @PathVariable String breweryId) {
        log.debug( "Getting breweries by id {}", breweryId );
        return this.breweryDao.getBreweryById( breweryId);
    }

    @GetMapping("/breweries/{breweryId}/beers")
    public List<Beer> getBeers( @PathVariable String breweryId) {
        log.debug( "Getting Beers for Brewery {}", breweryId );
        return this.breweryDao.getBreweryById( breweryId).getBeers();
    }

    @GetMapping("/beers")
    public List<Beer> getBeersWithExcption( ) {
        log.debug( "Getting Beers" );
        return this.breweryDao.getBeerList();
    }
    @GetMapping("/beers/favorite")
    public String getFavoriteBeer(){
        return String.format( "My favorite Beer is %s which is from %s.",
                this.favoriteBeer, this.favoriteBrewery );
    }
}
