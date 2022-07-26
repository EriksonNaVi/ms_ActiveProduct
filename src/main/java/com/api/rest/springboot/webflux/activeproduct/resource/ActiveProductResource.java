package com.api.rest.springboot.webflux.activeproduct.resource;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.springboot.webflux.activeproduct.dto.ActiveProductDto;
import com.api.rest.springboot.webflux.activeproduct.model.ActiveProduct;
import com.api.rest.springboot.webflux.activeproduct.service.ActiveProductService;
import com.api.rest.springboot.webflux.activeproduct.util.MapperUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ActiveProductResource extends MapperUtil{
  
  @Autowired
  ActiveProductService activeProductService;
  
  public Flux<ActiveProductDto> findAll() {
    return activeProductService.findAll().map(x -> map(x, ActiveProductDto.class));
  }
  
  public Mono<ActiveProductDto> create(ActiveProductDto activeProductDto) {
    ActiveProduct activeProduct = map(activeProductDto, ActiveProduct.class);
    activeProduct.setId(new ObjectId().toString());
    Mono<ActiveProduct> entity = activeProductService.save(activeProduct);
    return entity.map(x -> map(x, ActiveProductDto.class));
  }
  
  public Mono<ActiveProductDto> findById(String id) {
    return activeProductService.findById(id).switchIfEmpty(Mono.error(new Exception()))
        .map(x -> map(x, ActiveProductDto.class));
  }
  
  public Mono<ActiveProductDto> update(ActiveProductDto activeProductDto, String id) {

    return activeProductService.findById(id)
        .switchIfEmpty(Mono.error(new Exception()))
        .flatMap(x ->{
          x.setCreditCardNumber(activeProductDto.getCreditCardNumber());
          x.setStatus(activeProductDto.getStatus());
          x.setIdClient(activeProductDto.getIdClient());
          
          return activeProductService.save(x).map(y -> map(y, ActiveProductDto.class));
        });
  }
  
  public Mono<Void> delete(String id) {
    return activeProductService.findById(id).switchIfEmpty(Mono.error(new Exception()))
        .flatMap(x -> activeProductService.delete(x));
  }
  
  public Flux<ActiveProductDto> listByIdClient(String idClient){
    return activeProductService.byIdClient(idClient).switchIfEmpty(Mono.error(new Exception()))
        .map(x -> map(x, ActiveProductDto.class));
  }

}
