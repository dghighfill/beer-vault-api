package com.dh.beervaultapi.controller;

import com.dh.beervaultapi.properties.ApplicationFavoriteProperties;
import com.dh.beervaultapi.properties.ApplicationProperties;
import com.dh.beervaultapi.util.BeerUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BreweryController {

   private ApplicationFavoriteProperties favoriteProperties;

   private ApplicationProperties properties;

   public BreweryController( ApplicationProperties properties,
                             ApplicationFavoriteProperties favoriteProperties ) {
      this.properties = properties;
      this.favoriteProperties = favoriteProperties;
   }

   @GetMapping("breweries/favorite")
   public String getFavoriteBrewery(){
      return String.format( "My favorite Brewery is %s.",
              this.favoriteProperties.getBrewery() );
   }

   @GetMapping("breweries/favoriteBeer")
   public String getFavoriteBreweryWithBeer(){
      return String.format( "My favorite Beer is %s which is from %s.",
              this.properties.getFavorite().getName(), this.properties.getFavorite().getBrewery() );
   }
   @GetMapping("beer/static")
   public String getStaticBeer(){
      return BeerUtil.getFavoriteBeer();
   }
   @GetMapping("beer/static/properties")
   public String getStaticBeerWithBrewery(){
      return BeerUtil.getFavoriteBeerWithBrewery();
   }
}
