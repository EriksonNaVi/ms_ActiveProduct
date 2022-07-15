package com.api.rest.springboot.webflux.activeproduct.dto;

import java.time.LocalDate;

import lombok.Data;

 @Data
public class ActiveProductDto {
  
  private String id;
  private String creditCardNumber;
  private String status;
  private LocalDate expirationDate;
  private String idClient;

}
