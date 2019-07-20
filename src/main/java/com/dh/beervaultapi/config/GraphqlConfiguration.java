package com.dh.beervaultapi.config;

import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.domain.Beer;
import com.dh.beervaultapi.mutation.Mutation;
import com.dh.beervaultapi.resolver.BeerResolver;
import com.dh.beervaultapi.resolver.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class GraphqlConfiguration {
    @Bean
    public BeerDAO beerDAO() {
        List<Beer> beers = Arrays.asList(
                new Beer("1", "Tank 7", 3.79F, "path1"),
                new Beer("2", "Unfiltered Wheat Beer", 3.59F, "path2"),
                new Beer("3", "The Calling", 3.91F, "path3"),
                new Beer("4", "Single-Wide I.P.A.", 3.57F,"path4"),
                new Beer("5", "80-Acre Hoppy Wheat Beer", 3.88F,"path5"),
                new Beer("6", "The Sixth Glass", 3.62F,"path6"),
                new Beer("7", "Ginger Lemon Radler", 3.55F, "path7"),
                new Beer("8", "Pale Ale", 3.57F, "path8"),
                new Beer("9", "Tropical Pale Ale", 3.86F, "path9"),
                new Beer("10", "Bourbon Barrel Quad", 4.03F,"path10")
                );
        return new BeerDAO(beers);
    }

    @Bean
    public Query query(BeerDAO beerDAO) {
        return new Query(beerDAO);
    }

    @Bean
    public BeerResolver beerResolver() {
        return new BeerResolver();
    }

    @Bean
    public Mutation mutation() {
        return new Mutation();
    }
}
