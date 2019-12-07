package com.rafaelm.clinica.odonto;

import com.rafaelm.clinica.odonto.model.Client;
import com.rafaelm.clinica.odonto.repository.ClientRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@SpringBootApplication
public class OdontoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdontoApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ClientRepository repository) {
		return args -> {
			repository.save(new Client("Bilbo Baggins"));
		};
	}

}
