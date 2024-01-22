package com.consultorio.core.model;

public class Consultorios {
	private int idConsultorio;
	private int piso;
	
	
	public Consultorios() {
		this.idConsultorio = 0;
		this.piso = 1;
	}
	
	public Consultorios(int idConsultorio, int piso) {
		this.idConsultorio = idConsultorio;
		this.piso = piso;
	}

	public int getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}
}
