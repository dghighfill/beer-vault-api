package com.dh.beervaultapi.config;

import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.dao.BreweryDAO;
import com.dh.beervaultapi.dao.DistributionCenterDAO;
import com.dh.beervaultapi.domain.Beer;
import com.dh.beervaultapi.domain.Brewery;
import com.dh.beervaultapi.domain.DistributionCenter;
import com.dh.beervaultapi.mutation.Mutation;
import com.dh.beervaultapi.resolver.BeerQueryResolver;
import com.dh.beervaultapi.resolver.BeerResolver;
import com.dh.beervaultapi.resolver.BreweryQueryResolver;
import com.dh.beervaultapi.resolver.Query;
import com.dh.beervaultapi.subscription.Subscription;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class GraphqlConfiguration {
    @Bean
    public BeerDAO beerDAO() {
        Brewery boulevard = this.breweryDao().getBreweryById("1");
        List<Beer> beers = new ArrayList<Beer>(Arrays.asList(
                new Beer("1", "Tank 7", 3.79F, "path1", boulevard),
                new Beer("2", "Unfiltered Wheat Beer", 3.59F, "path2", boulevard),
                new Beer("3", "The Calling", 3.91F, "path3", boulevard),
                new Beer("4", "Single-Wide I.P.A.", 3.57F, "path4", boulevard),
                new Beer("5", "80-Acre Hoppy Wheat Beer", 3.88F, "path5", boulevard),
                new Beer("6", "The Sixth Glass", 3.62F, "path6", boulevard),
                new Beer("7", "Ginger Lemon Radler", 3.55F, "path7", boulevard),
                new Beer("8", "Pale Ale", 3.57F, "path8", boulevard),
                new Beer("9", "Tropical Pale Ale", 3.86F, "path9", boulevard),
                new Beer("10", "Bourbon Barrel Quad", 4.03F, "path10", boulevard)
        ));
        boulevard.setBeers(beers);


        // BUG This BeerDAO will only have the beers for the last list I build.  Need to traverse the beers now from
        // the Brewery.

//        Brewery samAdams= this.breweryDao().getBreweryById("2");
//        List<Beer> beers = new ArrayList<Beer>(Arrays.asList(
//                new Beer("1", "Samuel Adams Boston Lager", 3.42F, "path1", samAdams),
//                new Beer("2", "Sam '76", 3.456F, "path2", samAdams)
//        ));
//        samAdams.setBeers( beers );

        return new BeerDAO(beers);
    }

    @Bean
    public DistributionCenterDAO distributionCenterDAO() {
        List<DistributionCenter> distributionCenters = Arrays.asList(
                new DistributionCenter("1", "Central States Beverage Co", "14220 Wyandotte St", null, "Kansas City", "MO", "64145")
        );
        return new DistributionCenterDAO(distributionCenters);
    }

    @Bean
    public BreweryDAO breweryDao() {
        List<Brewery> breweries = new ArrayList<Brewery>(Arrays.asList(
                new Brewery("1", "Boulevard Brewing Company", "2501 Southwest Blvd", null, "Kansas City", "MO", "64108"),
                new Brewery("2", "Samuel Adams", "30 Germania St.", "", "Boston", "MA", "02130")
        ));
        return new BreweryDAO(breweries);
    }

    @Bean
    public Query query(BeerDAO beerDao, DistributionCenterDAO distributionCenterDAO, BreweryDAO breweryDao) {
        return new Query(beerDao, distributionCenterDAO(), breweryDao);
    }

    @Bean
    public Mutation mutation(BeerDAO beerDao) {
        return new Mutation(beerDao);
    }

    @Bean
    public Subscription subscription(BeerDAO beerDao) {
        return new Subscription(beerDao);
    }

    @Bean
    public BeerResolver beerResolver(BeerDAO beerDao) {
        return new BeerResolver(beerDao);
    }

    @Bean
    public BeerQueryResolver beerQueryResolver(BeerDAO beerDao) {
        return new BeerQueryResolver(beerDao);
    }

    @Bean
    public BreweryQueryResolver breweryQueryResolver(BreweryDAO breweryDao) {
        return new BreweryQueryResolver(breweryDao);
    }
}
