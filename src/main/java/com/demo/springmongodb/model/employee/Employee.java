package com.demo.springmongodb.model.employee;

import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection="employee") //Mongo DB annotation
public class Employee {
  
  @Id
  private ObjectId id;
  
  private String name;
  
  private String age;
  
  private String role;
  
  @NotNull
  private Address address;
}
