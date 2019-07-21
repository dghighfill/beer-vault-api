package com.dh.beervaultapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dh.beervaultapi.dao.BreweryDAO;
import com.dh.beervaultapi.domain.Brewery;

public class BreweryQueryResolver implements GraphQLQueryResolver {
    private BreweryDAO breweryDao;

    public BreweryQueryResolver(BreweryDAO breweryDao) {
        this.breweryDao = breweryDao;
    }

    public Brewery getBreweryById(String id) {
        return this.breweryDao.getBreweryById(id);
    }
}