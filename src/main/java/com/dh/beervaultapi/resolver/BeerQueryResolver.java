package com.dh.beervaultapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dh.beervaultapi.controller.MainController;
import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.dao.BreweryDAO;
import com.dh.beervaultapi.domain.Beer;
import com.dh.beervaultapi.domain.Brewery;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BeerQueryResolver implements GraphQLQueryResolver {

    private BeerDAO beerDao;
    private BreweryDAO breweryDao;
    private MainController mainController;

    public Beer getBeerById(Brewery brewery, String id) {
        Brewery b = this.breweryDao.getBreweryById( brewery.getId() );
        return beerDao.getBeerById( b, id );
    }

    // method has to match the schema field name for method
    public List<Beer> beers( Brewery brewery, Integer first, Integer last) {
        List<Beer> beers;
        List<Beer> beerResponse = new ArrayList<Beer>( );
        if( null != brewery ){
            beerResponse = getBeersForBrewery( brewery, first, last );
        }else {
            for( Brewery b : this.breweryDao.getBreweries() ){
                beerResponse.addAll( getBeersForBrewery( b, first, last ));
            }
        }

        return beerResponse;

    }

    @NotNull
    private List<Beer> getBeersForBrewery( Brewery brewery, Integer first, Integer last ) {

        List<Beer> beerResponse = new ArrayList<Beer>();

        List<Beer> beers;// Implementing via strangulation
        beers = this.mainController.getBeers( brewery.getId() );

        // Implementing the new way
        // beers = breweryDao.getBreweryById( brewery.getId() ).getBeers();

        if (first > 0 && last > 0) {
            beerResponse.addAll(beers.stream().limit(first).collect( Collectors.toList()));
            Integer reallyLast = beers.size() - last;
            if (reallyLast < first) {
                reallyLast = first;
            }
            beerResponse.addAll(beers.stream().skip(reallyLast).collect(Collectors.toList()));
        } else if (first > 0) {
            beerResponse.addAll(beers.stream().limit(first).collect(Collectors.toList()));
        } else if (last > 0) {
            Integer reallyLast = beers.size() + first - last;
            beerResponse.addAll(beers.stream().skip(reallyLast).collect(Collectors.toList()));
        } else {
            beerResponse.addAll(beers);
        }
        return beerResponse;
    }
}