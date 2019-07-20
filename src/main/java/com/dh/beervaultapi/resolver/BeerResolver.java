package com.dh.beervaultapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.domain.Beer;

//public class BeerResolver implements GraphQLResolver<Beer> {
public class BeerResolver implements GraphQLQueryResolver {
    private BeerDAO beerDao;

    public BeerResolver(BeerDAO bearDao) {
        this.beerDao = bearDao;
    }

    public Beer getBeer(Beer beer) {
        return beerDao.getBeerById( beer.getId() );
    }

    public Beer getBeerById(String id) {
        return beerDao.getBeerById(id);
    }

    public Integer countBeers() {
        return beerDao.getBeers().size();
    }


}