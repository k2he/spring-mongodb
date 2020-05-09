package com.demo.springmongodb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface EmployeeMixin {

  @JsonProperty("employeeName")
  abstract String getEmployee_name();
  
  @JsonProperty("employeeAge")
  abstract String getEmployee_age();
  
  @JsonProperty("employeeSalary")
  abstract String getEmployee_salary();
  
  @JsonProperty("employeeImageURL")
  abstract String getProfile_image();
  
}
