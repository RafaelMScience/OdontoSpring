package com.rafaelm.clinica.odonto.repository;

import com.rafaelm.clinica.odonto.model.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}