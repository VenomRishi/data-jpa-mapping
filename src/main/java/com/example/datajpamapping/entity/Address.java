package com.example.datajpamapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int addressId;
  private String temporaryAddress;
  private String permanentAddress;
  @JsonIgnoreProperties(value = "address")
  @OneToOne(mappedBy = "address")
  private Employee employee;

}
