package com.api.rest.springboot.webflux.activeproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.springboot.webflux.activeproduct.dto.ActiveProductDto;
import com.api.rest.springboot.webflux.activeproduct.resource.ActiveProductResource;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/active")
public class ActiveProductController {
  
  @Autowired
  private ActiveProductResource activeProductResource;
  
  @GetMapping
  public Flux<ActiveProductDto> findAll(){
      return activeProductResource.findAll();
  }
  
  @PostMapping
  public Mono<ActiveProductDto> createActive(@RequestBody ActiveProductDto activeProductDto){
      return activeProductResource.create(activeProductDto);
  }
  
  @GetMapping("/{id}")
  public Mono<ActiveProductDto> listById(@PathVariable String id){
    return activeProductResource.findById(id);
  }
  
  @PutMapping("/{id}")
  public Mono<ActiveProductDto> update(@RequestBody ActiveProductDto activeProductDto, @PathVariable String id){
      return activeProductResource.update(activeProductDto, id);
  }
  
  @DeleteMapping("/{id}")
  public Mono<Void> remove(@PathVariable String id){
    return activeProductResource.delete(id);
  }
  
  @GetMapping("/clientActive/{idClient}")
  public Flux<ActiveProductDto> listByIdClient(@PathVariable("idClient") String idClient){
    return activeProductResource.listByIdClient(idClient);
  }
  
  /*
  @GetMapping
  public Flux<ActiveProduct> toList(){
      return activeService.findAll();
  }
  
  @PostMapping
  public Mono<ActiveProduct> createActive(@Valid @RequestBody ActiveProduct active){
      return activeService.save(active);
  }
  
  @GetMapping("/{id}")
  public Mono<ResponseEntity<ActiveProduct>> listById(@PathVariable String id){
    return activeService.findById(id).map(c -> ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body(c))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
  
  @PutMapping("/{id}")
  public Mono<ResponseEntity<ActiveProduct>> edit(@RequestBody ActiveProduct active, @PathVariable String id) {
    return activeService.findById(id).flatMap(c -> {
      c.setCreditCardNumber(active.getCreditCardNumber());
      c.setStatus(active.getStatus());
      c.setIdClient(active.getIdClient());

      return activeService.save(c);
    }).map(c -> ResponseEntity.created(URI.create("/api/active/".concat(c.getId())))
        .contentType(MediaType.APPLICATION_JSON_UTF8).body(c)).defaultIfEmpty(ResponseEntity.notFound().build());
  }
  
  @GetMapping("/clientActive/{idClient}")
  public Flux<ActiveProduct> listByIdClient(@PathVariable("idClient") String idClient){
    return activeService.byIdClient(idClient);
  }*/
  
}
