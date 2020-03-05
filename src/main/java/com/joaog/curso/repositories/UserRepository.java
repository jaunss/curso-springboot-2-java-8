package com.joaog.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaog.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}