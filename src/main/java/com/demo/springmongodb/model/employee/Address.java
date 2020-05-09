package com.demo.springmongodb.model.employee;

import com.demo.springmongodb.model.employee.ZipCode.ZipCodeBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Address {
  private String street;
  
  private ZipCode zipCode;
  
  private String city;
  
  private String country;
}
