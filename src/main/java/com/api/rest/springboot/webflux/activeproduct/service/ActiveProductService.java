package com.api.rest.springboot.webflux.activeproduct.service;

import com.api.rest.springboot.webflux.activeproduct.model.ActiveProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ActiveProductService {

  public Flux<ActiveProduct> findAll();

  public Mono<ActiveProduct> findById(String id);

  public Mono<ActiveProduct> save(ActiveProduct active);

  public Mono<ActiveProduct> update(ActiveProduct active);

  public Mono<Void> delete(ActiveProduct active);
  
  public Flux<ActiveProduct> byIdClient(String idClient);
}
