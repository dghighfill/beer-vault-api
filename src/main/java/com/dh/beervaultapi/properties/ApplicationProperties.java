package com.dh.beervaultapi.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application")
@Data
public class ApplicationProperties {
   private ApplicationFavoriteProperties favorite;
}
