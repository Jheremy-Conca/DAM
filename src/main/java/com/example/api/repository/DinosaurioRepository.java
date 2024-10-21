package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entidad.Dinosaurio;

public interface DinosaurioRepository extends JpaRepository<Dinosaurio, Long> {
	
}
