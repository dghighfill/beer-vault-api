package com.dh.beervaultapi.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.domain.Beer;

public class Mutation implements GraphQLMutationResolver {
    BeerDAO beerDao;

    public Mutation(BeerDAO beerDao) {
        this.beerDao = beerDao;
    }

    public Beer createBeer(String name, Float rating, String image) {
        return beerDao.createBeer(name, rating, image);
    }

    public Beer deleteBeer(String id) {
        return beerDao.deleteBeer(id);
    }
}