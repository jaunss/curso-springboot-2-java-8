package com.joaog.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaog.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}