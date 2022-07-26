package com.api.rest.springboot.webflux.activeproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.springboot.webflux.activeproduct.model.ActiveProduct;
import com.api.rest.springboot.webflux.activeproduct.repository.ActiveProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ActiveProductServiceImpl implements ActiveProductService {

  @Autowired
  private ActiveProductRepository activeRepository;
  
  @Override
  public Flux<ActiveProduct> findAll() {
    
    return activeRepository.findAll();
  }

  @Override
  public Mono<ActiveProduct> findById(String id) {
    
    return activeRepository.findById(id);
  }

  @Override
  public Mono<ActiveProduct> save(ActiveProduct active) {
    
    return activeRepository.save(active);
  }

  @Override
  public Mono<Void> delete(ActiveProduct active) {
    
    return activeRepository.delete(active);
  }

  @Override
  public Flux<ActiveProduct> byIdClient(String idClient) {
    
    return activeRepository.findByIdClient(idClient);
  }

}
