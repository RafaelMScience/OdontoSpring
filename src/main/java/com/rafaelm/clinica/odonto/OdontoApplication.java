package com.rafaelm.clinica.odonto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@SpringBootApplication
public class OdontoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdontoApplication.class, args);
	}

}
