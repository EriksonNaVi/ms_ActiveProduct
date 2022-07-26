package com.api.rest.springboot.webflux.activeproduct.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "active_product")
public class ActiveProduct {
  
  @Id
  private String id;
  
  private String creditCardNumber;
  
  private String status;
  
  private LocalDate expirationDate;
  
  private String idClient;

}
