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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entidad.Usuario;
import com.example.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")  // Base URL for all endpoints
public class ApiControllerUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;  // Ensure you have this repository

    private static final List<Usuario> usuarios = new ArrayList<>();

    static {
        // Add 10 user records
        usuarios.add(new Usuario("usuario1", "correo1@example.com", "password1", "Nombre1", "Masculino", "Descripción 1", "url_imagen_1"));
        usuarios.add(new Usuario("usuario2", "correo2@example.com", "password2", "Nombre2", "Femenino", "Descripción 2", "url_imagen_2"));
        usuarios.add(new Usuario("usuario3", "correo3@example.com", "password3", "Nombre3", "Masculino", "Descripción 3", "url_imagen_3"));
        usuarios.add(new Usuario("usuario4", "correo4@example.com", "password4", "Nombre4", "Femenino", "Descripción 4", "url_imagen_4"));
        usuarios.add(new Usuario("usuario5", "correo5@example.com", "password5", "Nombre5", "Masculino", "Descripción 5", "url_imagen_5"));
        usuarios.add(new Usuario("usuario6", "correo6@example.com", "password6", "Nombre6", "Femenino", "Descripción 6", "url_imagen_6"));
        usuarios.add(new Usuario("usuario7", "correo7@example.com", "password7", "Nombre7", "Masculino", "Descripción 7", "url_imagen_7"));
        usuarios.add(new Usuario("usuario8", "correo8@example.com", "password8", "Nombre8", "Femenino", "Descripción 8", "url_imagen_8"));
        usuarios.add(new Usuario("usuario9", "correo9@example.com", "password9", "Nombre9", "Masculino", "Descripción 9", "url_imagen_9"));
        usuarios.add(new Usuario("usuario10", "correo10@example.com", "password10", "Nombre10", "Femenino", "Descripción 10", "url_imagen_10"));
    }

    @GetMapping("/listado")
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    @GetMapping("/buscar/{nomUsuario}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable String nomUsuario) {
        Usuario usuarioEncontrado = usuarios.stream()
                .filter(u -> u.getNomUsuario().equals(nomUsuario))
                .findFirst()
                .orElse(null);

        return usuarioEncontrado != null 
            ? ResponseEntity.ok(usuarioEncontrado) 
            : ResponseEntity.notFound().build();
    }

    @PostMapping("/agregar")
    public ResponseEntity<String> agregarUsuario(@RequestBody Usuario nuevoUsuario) {
        usuarios.add(nuevoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario agregado correctamente");
        
    }

    @PutMapping("/actualizar/{nomUsuario}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable String nomUsuario, @RequestBody Usuario usuarioActualizar) {
        Usuario usuarioExistente = usuarios.stream()
                .filter(u -> u.getNomUsuario().equals(nomUsuario))
                .findFirst()
                .orElse(null);
        
        if (usuarioExistente != null) {
            // Update fields of the existing user
            usuarioExistente.setCorreo(usuarioActualizar.getCorreo());
            usuarioExistente.setPassword(usuarioActualizar.getPassword());
            usuarioExistente.setNombre(usuarioActualizar.getNombre());
            usuarioExistente.setSexo(usuarioActualizar.getSexo());
            usuarioExistente.setDescripcion(usuarioActualizar.getDescripcion());
            usuarioExistente.setImagen(usuarioActualizar.getImagen());
            
            return ResponseEntity.ok("Usuario actualizado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    @DeleteMapping("/eliminar/{nomUsuario}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String nomUsuario) {
        Usuario usuarioEncontrado = usuarios.stream()
                .filter(u -> u.getNomUsuario().equals(nomUsuario))
                .findFirst()
                .orElse(null);

        if (usuarioEncontrado != null) {
            usuarios.remove(usuarioEncontrado);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }
}
