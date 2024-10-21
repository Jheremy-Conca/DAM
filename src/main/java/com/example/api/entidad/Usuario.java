package com.example.api.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    private String nomUsuario;
    private String correo;
    private String password;
    private String nombre;
    private String sexo;
    private String descripcion;
    private String imagen;
	public Usuario() {
		super();
	}
	
	public Usuario(String nomUsuario, String correo, String password, String nombre, String sexo, String descripcion,
			String imagen) {
		super();
		this.nomUsuario = nomUsuario;
		this.correo = correo;
		this.password = password;
		this.nombre = nombre;
		this.sexo = sexo;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

    // Getters and Setters
}
