package com.rafaelm.clinica.odonto.util.exception;

class ClientNotFoundException extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  ClientNotFoundException(Long id) {
    super("Could not find Client " + id);
  }
}