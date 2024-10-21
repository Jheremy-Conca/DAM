package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entidad.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {}
