package com.joaog.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaog.curso.entities.User;
import com.joaog.curso.repositories.UserRepository;

/* Registra a classe como Serviço do Spring */
@Service
public class UserService {
	
	/* Injeção de dependência */
	@Autowired
	private UserRepository repository;
	
	/* Retorna todos os usuários */
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	/* Inserção */
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	/* Deleção */
	public void delete(Long id) {
		repository.deleteById(id);
	}
}