package com.dh.beervaultapi.config;

import com.dh.beervaultapi.controller.MainController;
import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.dao.BreweryDAO;
import com.dh.beervaultapi.dao.DistributionCenterDAO;
import com.dh.beervaultapi.domain.Beer;
import com.dh.beervaultapi.domain.Brewery;
import com.dh.beervaultapi.domain.DistributionCenter;
import com.dh.beervaultapi.mutation.Mutation;
import com.dh.beervaultapi.resolver.BeerQueryResolver;
import com.dh.beervaultapi.resolver.BreweryQueryResolver;
import com.dh.beervaultapi.resolver.DistributionCenterQueryResolver;
import com.dh.beervaultapi.resolver.Query;
import com.dh.beervaultapi.subscription.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class GraphqlConfiguration {

    @Autowired
    private ApplicationContext context;

    @Bean
    public BeerDAO beerDAO() {
        return new BeerDAO();
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
        BreweryDAO breweryDao = new BreweryDAO( breweries );
        Brewery brewery = breweryDao.getBreweryById( "1" );
        breweryDao.getBreweryById( "1" ).setBeers( new ArrayList<Beer>(Arrays.asList(
            new Beer("1", "Tank 7", 3.79F, "path1", brewery),
            new Beer("2", "Unfiltered Wheat Beer", 3.59F, "path2", brewery) ,
            new Beer("3", "The Calling", 3.91F, "path3", brewery),
            new Beer("4", "Single-Wide I.P.A.", 3.57F, "path4", brewery),
            new Beer("5", "80-Acre Hoppy Wheat Beer", 3.88F, "path5", brewery),
            new Beer("6", "The Sixth Glass", 3.62F, "path6", brewery),
            new Beer("7", "Ginger Lemon Radler", 3.55F, "path7", brewery),
            new Beer("8", "Pale Ale", 3.57F, "path8", brewery),
            new Beer("9", "Tropical Pale Ale", 3.86F, "path9", brewery),
            new Beer("10", "Bourbon Barrel Quad", 4.03F, "path10", brewery)
        )));

        brewery = breweryDao.getBreweryById( "2" );
        brewery.setBeers(new ArrayList<Beer>(Arrays.asList(
            new Beer("1", "Samuel Adams Boston Lager", 3.42F, "path1", brewery),
            new Beer("2", "Sam '76", 3.456F, "path2", brewery)
        )));
        return breweryDao;
    }

    @Bean
    public Query query() {
        return new Query();
    }

    @Bean
    public Mutation mutation( BreweryDAO breweryDao, BeerDAO beerDao) {
        return new Mutation( breweryDao, beerDao);
    }

    @Bean
    public Subscription subscription(BeerDAO beerDao) {
        return new Subscription(beerDao);
    }

//    @Bean
//    public BeerResolver beerResolver(BeerDAO beerDao) {
//        return new BeerResolver(beerDao);
//    }

    @Bean
    public BreweryQueryResolver breweryQueryResolver(BreweryDAO breweryDao) {
        return new BreweryQueryResolver(breweryDao);
    }

    @Bean
    public BeerQueryResolver beerQueryResolver(BeerDAO beerDao, BreweryDAO breweryDao ) {
        MainController controller = context.getBean( MainController.class  );
        return new BeerQueryResolver(beerDao, breweryDao, controller );
    }

    @Bean
    public DistributionCenterQueryResolver distributionCenterQueryResolver(DistributionCenterDAO distributionCenterDao) {
        return new DistributionCenterQueryResolver(distributionCenterDao);
    }
}
