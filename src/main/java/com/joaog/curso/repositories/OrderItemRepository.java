package com.joaog.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaog.curso.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}