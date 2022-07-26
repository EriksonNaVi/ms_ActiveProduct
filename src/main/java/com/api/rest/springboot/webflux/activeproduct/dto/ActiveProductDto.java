package com.api.rest.springboot.webflux.activeproduct.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.api.rest.springboot.webflux.activeproduct.util.ValidationConstants;

import lombok.Data;

 @Data
public class ActiveProductDto {
  
  private String id;
  @NotNull(message = ValidationConstants.NOT_EMPTY)
  @Size(min = 16, max = 16, message =ValidationConstants.SIZE)
  private String creditCardNumber;
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  private String status;
  private LocalDate expirationDate;
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  private String idClient;

}
