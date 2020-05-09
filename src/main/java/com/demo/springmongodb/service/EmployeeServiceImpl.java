package com.demo.springmongodb.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.demo.springmongodb.config.AppProperties;
import com.demo.springmongodb.dto.ValueObject;
import com.demo.springmongodb.model.employee.Employee;
import com.demo.springmongodb.model.employee.PublicEmployee;
import com.demo.springmongodb.repository.EmployeeRepository;
import com.demo.springmongodb.utils.AppConstants;
import com.demo.springmongodb.utils.AppUtils;
import com.demo.springmongodb.utils.JsonUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  @NonNull
  private final EmployeeRepository employeeRepository;

  @NonNull
  private final MongoTemplate mongoTemplate;

  @NonNull
  private final RestTemplate restTemplate;

  @NonNull
  private final AppProperties appProperties;

  @Override
  public List<Employee> getAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee create(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public List<ValueObject> testMapReduce() {
    // Calculate average age for by each role
    MapReduceResults<ValueObject> results = mongoTemplate.mapReduce(AppConstants.MAPREDUCE_NAME,
        appProperties.getMapPath(), appProperties.getReducePath(), ValueObject.class);

    List<ValueObject> resultList = new ArrayList<ValueObject>();
    results.forEach(r -> resultList.add(r));

    return resultList;
  }

  @Override
  public PublicEmployee getPublicEmployee(String id) {
    String testId = "88776"; // test Id
    String uri = AppUtils.replaceWithParam(appProperties.getUrls().getSampleData(), testId);
    log.info("Request: " + JsonUtils.getRequestJson(HttpMethod.GET, uri, null));
    return restTemplate.getForObject(uri, PublicEmployee.class);
  }

  @Override
  public List<Employee> testSearch() {
    String testZipCode = "m2n4f5";
    List<Employee> emloyees = employeeRepository.findByAddress_ZipCode_ZipCode(testZipCode);
    return emloyees;
  }

  @Override
  public List<Employee> testSearchCombined() {
    String testName = "John";
    String testZipCode = "m2n4f5";
    List<Employee> emloyees = employeeRepository.findByNameAndAddress_ZipCode_ZipCode(testName, testZipCode);
    return emloyees;
  }

}
