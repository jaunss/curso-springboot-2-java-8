package com.joaog.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaog.curso.entities.User;
import com.joaog.curso.services.UserService;

/* @ResController diz que a classe UserResource é um recurso web implementada por um controlador REST */
@RestController
@RequestMapping(value = "/users") /* Caminho do recurso */
public class UserResource {
	
	@Autowired
	private UserService service;
	/* @GetMapping é uma notação para mapeamento de solicitações HTTP GET em métodos manipuladores específicos
	 * ou seja, retorna o o caminho especificado no @RequestMapping */
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}