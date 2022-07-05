package com.api.rest.springboot.webflux.activeproduct.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.api.rest.springboot.webflux.activeproduct.util.ValidationConstants;

import lombok.Data;

@Data
@Document(collection = "active_product")
public class ActiveProduct {
  
  @Id
  private String id;
  
  @NotNull(message = ValidationConstants.NOT_NULL)
  private String creditCardNumber;
  
  @NotNull(message = ValidationConstants.NOT_NULL)
  private String status;
  
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  private LocalDate expirationDate;
  
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  private String idClient;

}
