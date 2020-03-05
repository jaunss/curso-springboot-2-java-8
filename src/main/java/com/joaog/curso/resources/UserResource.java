package com.joaog.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaog.curso.entities.User;

/* @ResController diz que a classe UserResource é um recurso web implementada por um controlador REST */
@RestController
@RequestMapping(value = "/users") /* Caminho do recurso */
public class UserResource {
	
	/* @GetMapping é uma notação para mapeamento de solicitações HTTP GET em métodos manipuladores específicos
	 * ou seja, retorna o o caminho especificado no @RequestMapping */
	@GetMapping
	public ResponseEntity<User> findAll() {
		User us = new User(1L, "joao", "joaogcm_jb@outlook.com", "17996175794", "joao123");
		return ResponseEntity.ok().body(us);
	}
}