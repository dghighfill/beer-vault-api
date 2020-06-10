package com.dh.beervaultapi.util;

import com.dh.beervaultapi.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Component
public class BeerUtil {

   private static String name;

   @Value("${application.favorite.name}")
   // NOTE This method is not static.
   public void setName( String name ){
      BeerUtil.name = name;
   }

   private static ApplicationProperties properties;

   @Autowired
   public void setProperties( ApplicationProperties properties ){
      BeerUtil.properties = properties;
   }

   public static String getFavoriteBeer(){
      return String.format( "My favorite Beer is %s.", name );
   }

   public static String getFavoriteBeerWithBrewery(){
      return String.format( "My favorite Beer is %s which is from %s.",
              name, properties.getFavorite().getBrewery() );
   }
}
