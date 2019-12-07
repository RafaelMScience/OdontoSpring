package com.rafaelm.clinica.odonto.repository;

import com.rafaelm.clinica.odonto.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}