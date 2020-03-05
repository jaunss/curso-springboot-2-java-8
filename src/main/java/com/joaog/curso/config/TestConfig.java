package com.joaog.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joaog.curso.entities.User;
import com.joaog.curso.repositories.UserRepository;

/* Classe específica de configuração da aplicação */
/* O Spring vai rodar essa configuração somente quando estiver
 * no perfil de teste -> @Profile("test") */

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	/*
	 * Realiza a injeção de dependência e associa a instância do UserRepository á
	 * classe TestConfig
	 */
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}