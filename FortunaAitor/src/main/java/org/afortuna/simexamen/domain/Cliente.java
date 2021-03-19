package org.afortuna.simexamen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	//============================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private Integer dni;
	
	@Column (unique=false)
	private String nombre;
	
	//==============================
	public Cliente() {
		this.nombre="Aitor";
	}
	
	public Cliente(Integer dni, String nombre) {
		super();
		this.dni=dni;
		this.nombre=nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "["+this.dni+"] "+this.nombre;
	}
	
	
}
