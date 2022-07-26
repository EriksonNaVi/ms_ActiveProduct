package com.api.rest.springboot.webflux.activeproduct.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  private static final Logger logger = LoggerFactory.getLogger(ActiveProductController.class);

  @Autowired
  private ActiveProductResource activeProductResource;

  @GetMapping
  public Flux<ActiveProductDto> findAll() {
    logger.debug("Getting ActiveProduct");
    return activeProductResource.findAll();
  }

  @PostMapping
  public Mono<ActiveProductDto> createActive(@Valid @RequestBody ActiveProductDto activeProductDto) {
    logger.debug("Create ActiveProduct");
    return activeProductResource.create(activeProductDto);
  }

  @GetMapping("/{id}")
  public Mono<ActiveProductDto> listById(@PathVariable String id) {
    logger.debug("Getting ActiveProductbyid");
    return activeProductResource.findById(id);
  }

  @PutMapping("/{id}")
  public Mono<ActiveProductDto> update(@RequestBody ActiveProductDto activeProductDto, @PathVariable String id) {
    logger.debug("Putting ActiveProductbyid");
    return activeProductResource.update(activeProductDto, id);
  }

  @DeleteMapping("/{id}")
  public Mono<Void> remove(@PathVariable String id) {
    return activeProductResource.delete(id);
  }

  @GetMapping("/clientActive/{idClient}")
  public Flux<ActiveProductDto> listByIdClient(@PathVariable("idClient") String idClient) {
    return activeProductResource.listByIdClient(idClient);
  }

}
