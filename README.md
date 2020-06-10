# Beer Vault API 

Beer Vault is a reference architecture for me to explore new technoliges and apply them to a common domain.  This repo is focused on the API for the Beer Vault and provides proof of concepts exploring API frameworks.

## Application properties
### Injecting a single value
Injecting Spring Configuration can sometimes be a bit challenging.  Here are a few
ways to inject an application.yml file.

Give the following application.yml
```yaml
application:
  favorite:
    name: Dale's Pale Ale
    brewery: Oscar Blues
```

If you want to access this by using the @Value annotation then in one of your components
of Spring (e.g. @RestController), you can just add the following
```java
@Value( "${application.favorite.name}" )
private String favoriteBeer;

@Value( "${application.favorite.brewery}" )
private String favoriteBrewery;
```
And this will give you access to the property so that you can return it with this.favoriteBeer.
```java
@GetMapping("/beers/favorite")
public String getFavoriteBeer(){
    return String.format( "My favorite Beer is %s which is from %s.",
            this.favoriteBeer, this.favoriteBrewery );
}
```
### Injecting a class
You would first need to define a class that represents your application.yaml 
structure.  There's a bit of hierarchy in our yaml for demonstration purposes 
and there are some Domain classes that represent a beer, but since it has a
custom structure, we're going to make a different class to store these simple
two strings.

First create an Application.properties class that represent the same yaml configuration as above.
We'll assign a prefix so that we can point right to the configuration classes.  If you have nested set of properties see below the next section for an example.
```java
@ConfigurationProperties(prefix = "application.favorite")
@Data
public class ApplicationFavoriteProperties {
   private String name;
   private String brewery;
}
```
Next we have to create a Config class that Enables the Configuration properties for the ApplicationFavoriteProperties

```java
@Configuration
@EnableConfigurationProperties( ApplicationFavoriteProperties.class )
public class ApplicationFavoriteConfig {
}
```

Now all you have to do is in your Spring component's contstructor add this to the constructor to inject it.

```java
@RestController
public class BreweryController {

   private ApplicationFavoriteProperties favoriteProperties;

   public BreweryController( ApplicationFavoriteProperties favoriteProperties ) {
      this.favoriteProperties = favoriteProperties;
   }

   @GetMapping("breweries/favorite")
   public String getFavoriteBrewery(){
      return String.format( "My favorite Brewery is %s.",
              this.favoriteProperties.getBrewery() );
   }
}
```
  
### Injecting a nested class
NOTE: One thing when working with these properties files is that to expose the properties as a @Bean so that in can be injected in other places you have to have a corresponding config class.
This statement below exposes the bean so that you can add it to a constructor.
```java
@Configuration
@EnableConfigurationProperties( ApplicationProperties.class )
public class ApplicationConfig {
}
```
Then you just have a POJO to represent your nested classes.
```java
@ConfigurationProperties(prefix = "application")
@Data
public class ApplicationProperties {
   private ApplicationProperties properties;
}
```
You can also just add this at the application level
```java
@SpringBootApplication
@EnableConfigurationProperties( { ApplicationProperties.class, ApplicationFavoriteProperties.class} )
```

Then you can just traverse the POJO
```java
@GetMapping("breweries/favoriteBeer")
public String getFavoriteBreweryWithBeer(){
  return String.format( "My favorite Beer is %s which is from %s.",
          this.properties.getFavorite().getName(), this.properties.getFavorite().getBrewery() );
}
```
### Using the properies in Static Funtions
This is some what of a challenge and you have to do this a bit different.  Here are two different means by referencing the property directly and then to inject the properties class, then you have to @Autowired it.
```java
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
```
Then we have a RestContoller to exercise these methods.
```java
@GetMapping("beer/static")
public String getStaticBeer(){
  return BeerUtil.getFavoriteBeer();
}
@GetMapping("beer/static/properties")
public String getStaticBeerWithBrewery(){
  return BeerUtil.getFavoriteBeerWithBrewery();
}
```
