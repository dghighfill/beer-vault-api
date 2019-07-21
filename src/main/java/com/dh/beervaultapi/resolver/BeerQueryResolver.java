package com.dh.beervaultapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.domain.Beer;

public class BeerQueryResolver implements GraphQLQueryResolver {
    private BeerDAO beerDao;

    public BeerQueryResolver(BeerDAO bearDao) {
        this.beerDao = bearDao;
    }

    public Beer getBeerById(String id) {
        return beerDao.getBeerById(id);
    }

    public Integer countBeers() {
        return beerDao.getBeers().size();
    }


}