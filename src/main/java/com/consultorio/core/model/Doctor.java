package com.consultorio.core.model;

public class Doctor {
	private int idDoctor;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String especialidad;
	
	
	
	public Doctor() {
		this.idDoctor = 0;
		this.nombre = "";
		this.apellidoPaterno = "";
		this.apellidoMaterno = "";
		this.especialidad = "";
	}


	public Doctor(int idDoctor, String nombre, String apellidoPaterno, String apellidoMaterno, String especialidad) {
		this.idDoctor = idDoctor;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.especialidad = especialidad;
	}


	public int getIdDoctor() {
		return idDoctor;
	}


	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	public String getApellidoMaterno() {
		return apellidoMaterno;
	}


	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
}
