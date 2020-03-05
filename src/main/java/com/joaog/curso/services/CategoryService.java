package com.joaog.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaog.curso.entities.Category;
import com.joaog.curso.repositories.CategoryRepository;

/* Registra a classe como Serviço do Spring */
@Service
public class CategoryService {
	
	/* Injeção de dependência */
	@Autowired
	private CategoryRepository repository;
	
	/* Retorna todos os usuários */
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}