package com.joaog.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaog.curso.entities.Product;
import com.joaog.curso.repositories.ProductRepository;

/* Registra a classe como Serviço do Spring */
@Service
public class ProductService {
	
	/* Injeção de dependência */
	@Autowired
	private ProductRepository repository;
	
	/* Retorna todos os usuários */
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}