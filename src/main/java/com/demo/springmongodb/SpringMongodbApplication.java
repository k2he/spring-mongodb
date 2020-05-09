package com.demo.springmongodb;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbApplication.class, args);
	}

	 @Bean
	 public RestTemplate restTemplate() {
	   RestTemplate restTemplate = new RestTemplate();
	   MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	   converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_HTML));
	   restTemplate.getMessageConverters().add(converter);
	   return restTemplate;
	 }
}
