package com.joaog.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaog.curso.entities.Order;
import com.joaog.curso.repositories.OrderRepository;

/* Registra a classe como Serviço do Spring */
@Service
public class OrderService {
	
	/* Injeção de dependência */
	@Autowired
	private OrderRepository repository;
	
	/* Retorna todos os usuários */
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}