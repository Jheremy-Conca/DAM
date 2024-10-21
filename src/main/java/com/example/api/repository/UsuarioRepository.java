package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entidad.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {}
