package com.api.rest.springboot.webflux.activeproduct.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.springboot.webflux.activeproduct.model.ActiveProduct;
import com.api.rest.springboot.webflux.activeproduct.service.ActiveProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/active")
public class ActiveProductController {
  
  @Autowired
  private ActiveProductService activeService;
  
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
  }
  
}
