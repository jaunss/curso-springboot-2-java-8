package com.joaog.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaog.curso.entities.User;
import com.joaog.curso.services.UserService;

/* @ResController diz que a classe UserResource é um recurso web implementada por um controlador REST */
@RestController
@RequestMapping(value = "/users") /* Caminho do recurso */
public class UserResource {

	@Autowired
	private UserService service;

	/*
	 * @GetMapping é uma notação para mapeamento de solicitações HTTP GET em métodos
	 * manipuladores específicos ou seja, retorna o o caminho especificado
	 * no @RequestMapping
	 */
	@GetMapping
	public ResponseEntity<List<User>> findAll() {

		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/* Forma adequada de se inserir um recurso no banco de dados (Retorno 201 - Created) */
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	/* Forma adequada de se remover um recurso do banco de dados (Retorno 204 - No Content) */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/* Forma adequada de se atualizar um recurso no banco de dados (Retorno - ) */
	@PutMapping
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}