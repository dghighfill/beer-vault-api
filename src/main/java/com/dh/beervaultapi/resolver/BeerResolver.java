package com.dh.beervaultapi.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.domain.Beer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BeerResolver implements GraphQLResolver<Beer> {

    private BeerDAO beerDao;

    public Beer getBeer(Beer beer) {
        return beerDao.getBeerById(beer.getId());
    }
}
