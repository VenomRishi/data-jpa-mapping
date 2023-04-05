package com.example.datajpamapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int employeeId;
  private String name;
  @JsonIgnoreProperties(value = "employee")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinTable(name = "employee_address",
      joinColumns =
          { @JoinColumn(name = "employee_id", referencedColumnName = "employeeId") },
      inverseJoinColumns =
          { @JoinColumn(name = "address_id", referencedColumnName = "addressId") })
  private Address address;

}
