package com.example.datajpamapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int addressId;
  private String temporaryAddress;
  private String permanentAddress;

}
