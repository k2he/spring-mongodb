package com.demo.springmongodb.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.springmongodb.dto.ValueObject;
import com.demo.springmongodb.model.employee.Employee;
import com.demo.springmongodb.model.employee.PublicEmployee;
import com.demo.springmongodb.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
  
  @NonNull
  private EmployeeService employeeService;
  
  @RequestMapping(value="", method = RequestMethod.GET) 
  public List<Employee> getAllEmployees() {
    return employeeService.getAll();
  }
  
  @RequestMapping(value="", method = RequestMethod.POST) 
  public Employee createEmployees(@Valid @RequestBody Employee employee) {
    return employeeService.create(employee);
  }
  
  @RequestMapping(value="/mapReduce", method = RequestMethod.GET) 
  public List<ValueObject> mapReduce() {
    return employeeService.testMapReduce();
  }
  
  @RequestMapping(value="/testSearch", method = RequestMethod.GET) 
  public List<Employee> testSearch() {
    return employeeService.testSearch();
  }
  
  @RequestMapping(value="/testSearchCombined", method = RequestMethod.GET) 
  public List<Employee> testSearchCombined() {
    return employeeService.testSearchCombined();
  }
  
  @RequestMapping(value="/testPublicApi/{id}", method = RequestMethod.GET) 
  public PublicEmployee getAll(@PathVariable(value="id") String id) {
    return employeeService.getPublicEmployee(id);
  }
}
