package com.rafaelm.clinica.odonto.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import com.rafaelm.clinica.odonto.model.Schedule;
import com.rafaelm.clinica.odonto.repository.ScheduleRepository;
import com.rafaelm.clinica.odonto.util.exception.ScheduleNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

  private final ScheduleRepository repository;

  ScheduleController(ScheduleRepository scheduleRepository) {
    this.repository = scheduleRepository;
  }

  @GetMapping(value = "/{id}")
  public Schedule search(@PathVariable Long id) {
    Optional<Schedule> obj = repository.findById(id);
    return obj.orElseThrow(
        () -> new ScheduleNotFoundException("Não há agendamento com esse Id " + id + " " + Schedule.class.getName()));
  }

  @PostMapping
  public ResponseEntity<Void> insert(@Valid @RequestBody Schedule model) {
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand().toUri();
    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping(path = { "/{id}" })
  public ResponseEntity<?> delete(@PathVariable long id) {
    return repository.findById(id).map(record -> {
      repository.deleteById(id);
      return ResponseEntity.ok().build();
    }).orElse(ResponseEntity.notFound().build());
  }
}