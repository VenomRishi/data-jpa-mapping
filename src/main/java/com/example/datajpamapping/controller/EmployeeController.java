package com.example.datajpamapping.controller;

import com.example.datajpamapping.entity.Address;
import com.example.datajpamapping.entity.Employee;
import com.example.datajpamapping.repository.AddressRepository;
import com.example.datajpamapping.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private AddressRepository addressRepository;

  @GetMapping("/employees")
  public List<Employee> getEmployees() {
    return employeeRepository.findAll();
  }

  @GetMapping("/addresses")
  public List<Address> getAddresses() {
    return addressRepository.findAll();
  }

  @PostMapping("/employee")
  public Employee addEmployee(@RequestBody Employee employee) {
    Address savedAddress = addressRepository.save(employee.getAddress());
    employee.setAddress(savedAddress);
    return employeeRepository.save(employee);
  }
}
