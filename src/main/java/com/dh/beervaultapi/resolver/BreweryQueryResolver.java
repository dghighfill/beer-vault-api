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

    public Integer countBeers( Brewery brewery ) {
        int count = 0;
        if( null != brewery ){
            count = breweryDao.getBreweryById( brewery.getId() ).getBeers().size();
        }else
        {
            for( Brewery b : this.breweries() ){
                count += b.getBeers().size();
            }
        }
        return count;
    }
}