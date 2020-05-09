package com.demo.springmongodb.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.demo.springmongodb.model.employee.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
  
  // Search by ZipCode inside Employee.Address.ZipCode.zipCode field
  List<Employee> findByAddress_ZipCode_ZipCode(String zipCode);

  // Search by Employee.name && Employee.Address.ZipCode.zipCode fields
  List<Employee> findByNameAndAddress_ZipCode_ZipCode(String name, String zipCode);
  
}
