package com.dh.beervaultapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dh.beervaultapi.dao.BreweryDAO;
import com.dh.beervaultapi.domain.Brewery;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BreweryQueryResolver implements GraphQLQueryResolver {
    private BreweryDAO breweryDao;

    public List<Brewery> breweries() {
        return this.breweryDao.getBreweries();
    }

    public Brewery getBreweryById(String id) {
        return this.breweryDao.getBreweryById(id);
    }
}