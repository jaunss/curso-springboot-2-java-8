package com.joaog.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaog.curso.entities.Product;
import com.joaog.curso.services.ProductService;

/* @ResController diz que a classe ProductResource é um recurso web implementada por um controlador REST */
@RestController
@RequestMapping(value = "/products") /* Caminho do recurso */
public class ProductResource {
	
	@Autowired
	private ProductService service;
	/* @GetMapping é uma notação para mapeamento de solicitações HTTP GET em métodos manipuladores específicos
	 * ou seja, retorna o o caminho especificado no @RequestMapping */
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}