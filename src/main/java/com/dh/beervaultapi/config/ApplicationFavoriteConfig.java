package com.dh.beervaultapi.config;

import com.dh.beervaultapi.properties.ApplicationFavoriteProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
// This statement can just be at the application leve.  Not sure what that does to test classes and
// it may be better here.
//@EnableConfigurationProperties( ApplicationFavoriteProperties.class )
public class ApplicationFavoriteConfig {
}
