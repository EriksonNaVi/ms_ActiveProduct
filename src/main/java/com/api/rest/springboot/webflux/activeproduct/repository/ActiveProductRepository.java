package com.api.rest.springboot.webflux.activeproduct.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.springboot.webflux.activeproduct.model.ActiveProduct;

import reactor.core.publisher.Flux;

@Repository
public interface ActiveProductRepository extends ReactiveMongoRepository<ActiveProduct, String>{
  
  Flux<ActiveProduct> findByIdClient(String idClient);

}
