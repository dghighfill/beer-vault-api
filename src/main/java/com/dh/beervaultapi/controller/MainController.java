package com.dh.beervaultapi.controller;

import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.dao.BreweryDAO;
import com.dh.beervaultapi.domain.Beer;
import com.dh.beervaultapi.domain.Brewery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private BreweryDAO breweryDao;
    private BeerDAO beerDao;

    public MainController( BreweryDAO breweryDao) {
        this.breweryDao = breweryDao;
    }

    @GetMapping("/breweries")
    public List<Brewery> getBreweries() {
        return this.breweryDao.getBreweries();
    }

    @GetMapping("/breweries/{breweryId}")
    public Brewery getBreweryById( @PathVariable String breweryId) {
        return this.breweryDao.getBreweryById( breweryId);
    }

    @GetMapping("/breweries/{breweryId}/beers")
    public List<Beer> getBeers( @PathVariable String breweryId) {
        return this.breweryDao.getBreweryById( breweryId).getBeers();
    }

    @GetMapping("/beers")
    public List<Beer> getBeersWithExcption( ) {
        return this.breweryDao.getBeerList();
    }
}
