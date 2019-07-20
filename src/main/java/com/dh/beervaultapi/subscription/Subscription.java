package com.dh.beervaultapi.subscription;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.domain.Beer;

public class Subscription implements GraphQLSubscriptionResolver {
    private BeerDAO beerDao;

    public Subscription(BeerDAO beerDao) {
        this.beerDao = beerDao;
    }

    public Beer newBeer() {
        return beerDao.getBeerById("1");
    }
}
