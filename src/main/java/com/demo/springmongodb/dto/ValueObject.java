package com.demo.springmongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValueObject {

  private String role;
  
  private int value;

}
