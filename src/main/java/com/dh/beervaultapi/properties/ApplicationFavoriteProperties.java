package com.dh.beervaultapi.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.favorite")
@Data
public class ApplicationFavoriteProperties {
   private String name;
   private String brewery;
}
