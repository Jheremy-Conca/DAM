package com.example.api.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_dinosaurios")
public class Dinosaurio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomDinosaurio;
    private String nomCientifico;
    private String periodo;
    private String habitat;
    private String dieta;
    private String datosCuriosos;
    private String imagen;
    private String familia;
    private String tamaño;
    private String peso;
    private String descripcion;
    private String ubicacion;
	public Dinosaurio() {
		super();
	}
	
	public Dinosaurio(Long id, String nomDinosaurio, String nomCientifico, String periodo, String habitat, String dieta,
			String datosCuriosos, String imagen, String familia, String tamaño, String peso, String descripcion,
			String ubicacion) {
		super();
		this.id = id;
		this.nomDinosaurio = nomDinosaurio;
		this.nomCientifico = nomCientifico;
		this.periodo = periodo;
		this.habitat = habitat;
		this.dieta = dieta;
		this.datosCuriosos = datosCuriosos;
		this.imagen = imagen;
		this.familia = familia;
		this.tamaño = tamaño;
		this.peso = peso;
		this.descripcion = descripcion;
		this.ubicacion = ubicacion;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomDinosaurio() {
		return nomDinosaurio;
	}
	public void setNomDinosaurio(String nomDinosaurio) {
		this.nomDinosaurio = nomDinosaurio;
	}
	public String getNomCientifico() {
		return nomCientifico;
	}
	public void setNomCientifico(String nomCientifico) {
		this.nomCientifico = nomCientifico;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getHabitat() {
		return habitat;
	}
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	public String getDieta() {
		return dieta;
	}
	public void setDieta(String dieta) {
		this.dieta = dieta;
	}
	public String getDatosCuriosos() {
		return datosCuriosos;
	}
	public void setDatosCuriosos(String datosCuriosos) {
		this.datosCuriosos = datosCuriosos;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public String getTamaño() {
		return tamaño;
	}
	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

    
}
