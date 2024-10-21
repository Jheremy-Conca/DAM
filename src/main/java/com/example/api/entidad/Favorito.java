package com.example.api.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_favoritos")
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idDinosaurio;
    private String nomUsuario;
	public Favorito() {
		super();
	}
	
	public Favorito(Long id, Long idDinosaurio, String nomUsuario) {
		super();
		this.id = id;
		this.idDinosaurio = idDinosaurio;
		this.nomUsuario = nomUsuario;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdDinosaurio() {
		return idDinosaurio;
	}
	public void setIdDinosaurio(Long idDinosaurio) {
		this.idDinosaurio = idDinosaurio;
	}
	public String getNomUsuario() {
		return nomUsuario;
	}
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

    
}