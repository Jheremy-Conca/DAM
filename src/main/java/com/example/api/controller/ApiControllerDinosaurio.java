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

import com.example.api.entidad.Dinosaurio;
import com.example.api.repository.DinosaurioRepository;

@RestController
@RequestMapping("/dinosaurio")  // Base URL for all endpoints
public class ApiControllerDinosaurio {
	
	
    @Autowired
    private DinosaurioRepository dinosaurioRepository;
    
    private static final List<Dinosaurio> dinosaurio = new ArrayList<>();


    static {
        dinosaurio.add(new Dinosaurio(
            1L,  // id
            "Baryonyx",  // nomDinosaurio
            "Baryonyx walkeri",  // nomCientifico
            "Cretácico",  // periodo
            "Zonas pantanosas",  // habitat
            "Carnívoro",  // dieta
            "Tenía una garra gigante en su pulgar",  // datosCuriosos
            "url_de_imagen_baryonyx",  // imagen
            "Spinosauridae",  // familia
            "8-9 metros",  // tamaño
            "1.7 toneladas",  // peso
            "Un dinosaurio carnívoro semiacuático",  // descripcion
            "Europa, principalmente en Inglaterra"  // ubicacion
        ));

        dinosaurio.add(new Dinosaurio(
            2L,  // id
            "Triceratops",  // nomDinosaurio
            "Triceratops horridus",  // nomCientifico
            "Cretácico tardío",  // periodo
            "Praderas",  // habitat
            "Herbívoro",  // dieta
            "Conocido por sus tres cuernos faciales",  // datosCuriosos
            "url_de_imagen_triceratops",  // imagen
            "Ceratopsidae",  // familia
            "9 metros",  // tamaño
            "6-12 toneladas",  // peso
            "Era uno de los últimos dinosaurios antes de la extinción",  // descripcion
            "Norteamérica"  // ubicacion
        ));

        dinosaurio.add(new Dinosaurio(
            3L,  // id
            "Velociraptor",  // nomDinosaurio
            "Velociraptor mongoliensis",  // nomCientifico
            "Cretácico",  // periodo
            "Desiertos",  // habitat
            "Carnívoro",  // dieta
            "Era mucho más pequeño que su representación en películas",  // datosCuriosos
            "url_de_imagen_velociraptor",  // imagen
            "Dromaeosauridae",  // familia
            "1.8 metros",  // tamaño
            "15-20 kg",  // peso
            "Un dinosaurio muy rápido y ágil",  // descripcion
            "Mongolia y China"  // ubicacion
        ));

        dinosaurio.add(new Dinosaurio(
            4L,  // id
            "Stegosaurus",  // nomDinosaurio
            "Stegosaurus stenops",  // nomCientifico
            "Jurásico tardío",  // periodo
            "Bosques",  // habitat
            "Herbívoro",  // dieta
            "Tenía placas óseas en su espalda para defensa o regulación térmica",  // datosCuriosos
            "url_de_imagen_stegosaurus",  // imagen
            "Stegosauridae",  // familia
            "9 metros",  // tamaño
            "2 toneladas",  // peso
            "Un dinosaurio conocido por su cola con púas",  // descripcion
            "Norteamérica y Europa"  // ubicacion
        ));
    }


  
    @GetMapping("/listado")
    public List<Dinosaurio> dinosaurios() {
        return dinosaurio;
    }

    @GetMapping("/buscar/{nomUsuario}")
    public ResponseEntity<Dinosaurio> getDinosaurio(@PathVariable String nomUsuario) {
        Dinosaurio dinosaurioEncontrado = dinosaurio.stream()
                .filter(d -> d.getNomDinosaurio().equals(nomUsuario))
                .findFirst()
                .orElse(null);

        return dinosaurioEncontrado != null 
            ? ResponseEntity.ok(dinosaurioEncontrado) 
            : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteDinosaurio(@PathVariable Long id) {
        // Buscar el dinosaurio en la lista
        Dinosaurio dinosaurioEncontrado = dinosaurio.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        // Si el dinosaurio se encuentra, eliminarlo de la lista
        if (dinosaurioEncontrado != null) {
            dinosaurio.remove(dinosaurioEncontrado); // Eliminar el dinosaurio encontrado
            return ResponseEntity.ok("Dinosaurio eliminado correctamente"); // Devuelve 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dinosaurio no encontrado"); // Devuelve 404 Not Found
        }
    }

    
    @PostMapping("/agregar")
    public ResponseEntity<String> addDinosaurio(@RequestBody Dinosaurio nuevoDinosaurio) {
        Long id = dinosaurio.stream().mapToLong(Dinosaurio::getId).max().orElse(0) + 1;
        nuevoDinosaurio.setId(id);
        dinosaurio.add(nuevoDinosaurio); 
        return ResponseEntity.status(HttpStatus.CREATED).body("Dinosaurio agregado correctamente");
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> updateDinosaurio(@PathVariable Long id, @RequestBody Dinosaurio dinosaurioActualizar) {
        Dinosaurio dinosaurioExistente = this.dinosaurio.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        if (dinosaurioExistente != null) {
            // Actualizar los campos del dinosaurio existente
            dinosaurioExistente.setNomDinosaurio(dinosaurioActualizar.getNomDinosaurio());
            dinosaurioExistente.setNomCientifico(dinosaurioActualizar.getNomCientifico());
            dinosaurioExistente.setPeriodo(dinosaurioActualizar.getPeriodo());
            dinosaurioExistente.setHabitat(dinosaurioActualizar.getHabitat());
            dinosaurioExistente.setDieta(dinosaurioActualizar.getDieta());
            dinosaurioExistente.setDatosCuriosos(dinosaurioActualizar.getDatosCuriosos());
            dinosaurioExistente.setImagen(dinosaurioActualizar.getImagen());
            dinosaurioExistente.setFamilia(dinosaurioActualizar.getFamilia());
            dinosaurioExistente.setTamaño(dinosaurioActualizar.getTamaño());
            dinosaurioExistente.setPeso(dinosaurioActualizar.getPeso());
            dinosaurioExistente.setDescripcion(dinosaurioActualizar.getDescripcion());
            dinosaurioExistente.setUbicacion(dinosaurioActualizar.getUbicacion());
            
            return ResponseEntity.ok("Dinosaurio actualizado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dinosaurio no encontrado");
        }
    }	
}
