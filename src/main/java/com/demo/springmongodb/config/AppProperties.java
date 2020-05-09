package com.demo.springmongodb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "app") // find app.* values in property file
public class AppProperties {

  private Urls urls;
  
  private String mapPath;
  
  private String reducePath;
  
}
