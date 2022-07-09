package com.api.rest.springboot.webflux.activeproduct.service;

import com.api.rest.springboot.webflux.activeproduct.model.ActiveProduct;
import com.api.rest.springboot.webflux.activeproduct.util.Crud;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ActiveProductService extends Crud<ActiveProduct, String>{

  public Flux<ActiveProduct> byIdClient(String idClient);
}
