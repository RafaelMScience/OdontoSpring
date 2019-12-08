package com.rafaelm.clinica.odonto.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Entity
public class Schedule implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate date;
  private LocalTime time;
  private Boolean cancell;

  public Schedule() {
  }

  public Schedule(LocalDate date, LocalTime time, Boolean cancell) {
    super();
    this.setDate(date);
    this.setTime(time);
    this.setCancell(cancell);
  }

  public Boolean getCancell() {
    return cancell;
  }

  public void setCancell(Boolean cancell) {
    this.cancell = cancell;
  }

  public LocalTime getTime() {
    return time;
  }

  public void setTime(LocalTime time) {
    this.time = time;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}