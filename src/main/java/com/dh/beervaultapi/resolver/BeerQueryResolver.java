package com.dh.beervaultapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dh.beervaultapi.controller.BeerController;
import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.domain.Beer;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BeerQueryResolver implements GraphQLQueryResolver {

    private BeerDAO beerDao;
    private BeerController beerController;

    public Beer getBeerById(String id) {
        return beerDao.getBeerById(id);
    }

    public Integer countBeers() {
        return beerDao.getBeers().size();
    }

    // method has to match the schema field name for method
    public List<Beer> beers(Integer first, Integer last) {
        List<Beer> beers;
        List<Beer> beerResponse = new ArrayList<Beer>();

        // Implementing the new way
//        beers = beerDao.getBeers();

        // Implementing via strangulation
        beers = this.beerController.getBeers();

        if (first > 0 && last > 0) {
            beerResponse.addAll(beers.stream().limit(first).collect(Collectors.toList()));
            Integer reallyLast = beers.size() - last;
            if (reallyLast < first) {
                reallyLast = first;
            }
            beerResponse.addAll(beers.stream().skip(reallyLast).collect(Collectors.toList()));
        } else if (first > 0) {
            beerResponse.addAll(beers.stream().limit(first).collect(Collectors.toList()));
        } else if (last > 0) {
            Integer reallyLast = beers.size() + first - last;
            beerResponse.addAll(beers.stream().skip(reallyLast).collect(Collectors.toList()));
        } else {
            beerResponse.addAll(beers);
        }
        return beerResponse;
    }
}