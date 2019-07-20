package com.dh.beervaultapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.dao.DistributionCenterDAO;
import com.dh.beervaultapi.domain.Beer;
import com.dh.beervaultapi.domain.DistributionCenter;

import java.util.List;
import java.util.stream.Collectors;

public class Query implements GraphQLQueryResolver {
    private BeerDAO beerDao;
    private DistributionCenterDAO distributionCenterDAO;

    public Query(BeerDAO beerDao, DistributionCenterDAO distributionCenterDAO) {
        this.beerDao = beerDao;
        this.distributionCenterDAO = distributionCenterDAO;
    }

    // method has to match the schema field name for method
    public List<Beer> beers(Integer first) {
        if (null != first) {
            return beerDao.getBeers().stream().limit(first).collect(Collectors.toList());
        }
        return beerDao.getBeers();
    }

/*
 public List < User > getUsers(int first, int last) {
  if ((last == 0) || (last < first)) {
   // Ignore last if invalid value was specified
   last = (int) this.store.count();
  }
  return this.store.findAllById(
   IntStream.rangeClosed(first, last)
   .boxed()
   .collect(Collectors.toList())
  );
 }
 */

    public List<DistributionCenter> distributionCenters() {
        return distributionCenterDAO.getDistributionCenters();
    }

}
