package com.dh.beervaultapi;

import com.dh.beervaultapi.properties.ApplicationFavoriteProperties;
import com.dh.beervaultapi.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties( { ApplicationProperties.class, ApplicationFavoriteProperties.class} )
public class BeerVaultApiApplication {

	public static void main( String[] args) {
		SpringApplication.run(BeerVaultApiApplication.class, args);
	}

}
