package com.rafaelm.clinica.odonto;

import java.util.stream.LongStream;

import com.rafaelm.clinica.odonto.model.Client;
import com.rafaelm.clinica.odonto.repository.ClientRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OdontoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdontoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClientRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11).mapToObj(i -> {
				Client c = new Client();
				c.setName("Contact " + i);
				return c;
			}).map(v -> repository.save(v)).forEach(System.out::println);
		};
	}
}
