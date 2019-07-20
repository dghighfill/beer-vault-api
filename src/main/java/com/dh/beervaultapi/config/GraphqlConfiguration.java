package com.dh.beervaultapi.config;

import com.dh.beervaultapi.dao.BeerDAO;
import com.dh.beervaultapi.domain.Beer;
import com.dh.beervaultapi.resolver.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class GraphqlConfiguration {
    @Bean
    public BeerDAO beerDAO(){
         List<Beer> beers = Arrays.asList(
            new Beer( "1", "Wheat", "path1"),
            new Beer( "2", "Ale", "path2")
         );
         return new BeerDAO( beers );
    }

    @Bean
    public Query query( BeerDAO beerDAO ){
        return new Query( beerDAO );
    }
}
