package com.rafaelm.clinica.odonto.controller;

import java.util.List;

import com.rafaelm.clinica.odonto.model.Client;
import com.rafaelm.clinica.odonto.repository.ClientRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/clients" })
public class ClientController {

  private final ClientRepository repository;

  ClientController(ClientRepository clientRepository) {
    this.repository = clientRepository;
  }

  @GetMapping
  public List findAll() {
    return repository.findAll();
  }

  @GetMapping(path = { "/{id}" })
  public ResponseEntity<Client> findById(@PathVariable long id) {
    return (repository.findById(id)).map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
  }
}