package com.demo.springmongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import com.demo.springmongodb.dto.EmployeeMixin;
import com.demo.springmongodb.dto.PublicEmployeeMixin;
import com.demo.springmongodb.model.employee.Employee;
import com.demo.springmongodb.model.employee.PublicEmployee;

@Configuration
public class JacksonMixinConfig {

  @Bean
  public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.mixIn(Employee.class, EmployeeMixin.class);
    builder.mixIn(PublicEmployee.class, PublicEmployeeMixin.class);
    return builder;
  }
}
