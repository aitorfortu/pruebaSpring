package org.afortuna.simexamen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habitacion {
	
	//===============================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private int numHabitacion;
	
	@Column(unique=false)
	private int numCamas;
	
	public Habitacion() {
		this.numHabitacion=100;
	}
	
	public Habitacion(int numHabitacion, int numCamas) {
		super();
		this.numHabitacion=numHabitacion;
		this.numCamas=numCamas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public int getNumCamas() {
		return numCamas;
	}

	public void setNumCamas(int numCamas) {
		this.numCamas = numCamas;
	}

	@Override
	public String toString() {
		return "[" +this.numHabitacion + "("+this.numCamas+")" + "]";
	}

}
