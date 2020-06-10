package com.dh.beervaultapi.config;

import com.dh.beervaultapi.properties.ApplicationFavoriteProperties;
import com.dh.beervaultapi.properties.ApplicationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
// I think this could just be included at the application level.
//@EnableConfigurationProperties( ApplicationProperties.class )
public class ApplicationConfig {
}
