package com.demo.springmongodb.model.employee;

import lombok.Data;

@Data
public class PublicEmployee {
  
  private Long id;
  
  private String employee_name;
  
  private String employee_salary;
  
  private String employee_age;
  
  private String profile_Image;
}
