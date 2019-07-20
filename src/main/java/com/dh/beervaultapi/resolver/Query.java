package com.dh.beervaultapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.domain.Beer;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    private BeerDAO beerDao;

    public Query(BeerDAO beerDao) {
        this.beerDao = beerDao;
    }

    // method has to match the schema
    public List<Beer> beers() {
        return beerDao.getBeers();
    }

    public Beer getBeerById(String id) {
        return beerDao.getBeerById( id );
    }

    public Integer countBeers(){
        return beerDao.getBeers().size();
    }
}
