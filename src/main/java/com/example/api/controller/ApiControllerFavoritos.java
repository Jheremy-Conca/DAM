package com.example.api.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entidad.Dinosaurio;
import com.example.api.entidad.Favorito;
import com.example.api.repository.FavoritoRepository;

@RestController
@RequestMapping("/favoritos")  // Base URL for all endpoints
public class ApiControllerFavoritos {
    
    @Autowired
    private FavoritoRepository favoritosRepository;  // Asegúrate de tener este repositorio

    private static final List<Favorito> favoritos = new ArrayList<>();

    static {
        // Agregar 10 registros de favoritos
        favoritos.add(new Favorito(1L, 1L, "usuario1"));
        favoritos.add(new Favorito(2L, 2L, "usuario2"));
        favoritos.add(new Favorito(3L, 3L, "usuario3"));
        favoritos.add(new Favorito(4L, 1L, "usuario4"));
        favoritos.add(new Favorito(5L, 2L, "usuario5"));
        favoritos.add(new Favorito(6L, 3L, "usuario6"));
        favoritos.add(new Favorito(7L, 1L, "usuario7"));
        favoritos.add(new Favorito(8L, 2L, "usuario8"));
        favoritos.add(new Favorito(9L, 3L, "usuario9"));
    }

    @GetMapping("/listado")
    public List<Favorito> obtenerFavoritos() {
        return favoritos;
    }

    @PostMapping("/agregar")
    public ResponseEntity<String> agregarFavorito(@RequestBody Favorito nuevoFavorito) {
        Long id = favoritos.stream().mapToLong(Favorito::getId).max().orElse(0) + 1;
        nuevoFavorito.setId(id);
        favoritos.add(nuevoFavorito); 
        return ResponseEntity.status(HttpStatus.CREATED).body("Favorito agregado correctamente");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarFavorito(@PathVariable Long id) {
        Favorito favoritoEncontrado = favoritos.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (favoritoEncontrado != null) {
            favoritos.remove(favoritoEncontrado);
            return ResponseEntity.ok("Favorito eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Favorito no encontrado");
        }
    }
}
