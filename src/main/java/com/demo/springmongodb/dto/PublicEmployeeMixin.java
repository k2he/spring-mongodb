package com.demo.springmongodb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface PublicEmployeeMixin {

  @JsonProperty("name")
  abstract String getName();
  
  @JsonIgnore
  abstract String getId();
}
