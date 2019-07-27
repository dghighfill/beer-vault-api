package com.dh.beervaultapi.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.dao.BreweryDAO;
import com.dh.beervaultapi.domain.Beer;
import com.dh.beervaultapi.domain.Brewery;

public class Mutation implements GraphQLMutationResolver {
    BreweryDAO breweryDao;
    BeerDAO beerDao;

    public Mutation(BreweryDAO breweryDao, BeerDAO beerDao ) {
        this.breweryDao = breweryDao;
        this.beerDao = beerDao;
    }

    public Beer createBeer( Brewery brewery, String name, Float rating, String image) {
        Beer beer = beerDao.createBeer(breweryDao.getBreweryById( brewery.getId() ), name, rating, image);
        return beer;
    }

    public Beer deleteBeer(Brewery brewery, String id) {
        return beerDao.deleteBeer(breweryDao.getBreweryById( brewery.getId() ), id);
    }
}