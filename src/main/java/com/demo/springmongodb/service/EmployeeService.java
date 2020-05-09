package com.demo.springmongodb.service;

import java.util.List;
import com.demo.springmongodb.dto.ValueObject;
import com.demo.springmongodb.model.employee.Employee;
import com.demo.springmongodb.model.employee.PublicEmployee;

public interface EmployeeService {
  public List<Employee> getAll();

  public Employee create(Employee employee);

  public List<ValueObject> testMapReduce();
  
  public PublicEmployee getPublicEmployee(String id);
  
  public List<Employee> testSearch();
  
  public List<Employee> testSearchCombined();

}
