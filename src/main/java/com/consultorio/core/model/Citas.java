package com.consultorio.core.model;

public class Citas {
	private int idCita;
	private int idConsultorio;
	private int idDoctor;
	private String horarioConsulta;
	private String nombrePaciente;
	
	
	
	public Citas() {
		this.idCita = 0;
		this.idConsultorio = 0;
		this.idDoctor = 0;
		this.horarioConsulta = "";
		this.nombrePaciente = "";
	}



	public Citas(int idCita, int idConsultorio, int idDoctor, String horarioConsulta, String nombrePaciente) {
		this.idCita = idCita;
		this.idConsultorio = idConsultorio;
		this.idDoctor = idDoctor;
		this.horarioConsulta = horarioConsulta;
		this.nombrePaciente = nombrePaciente;
	}



	public int getIdCita() {
		return idCita;
	}



	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}



	public int getIdConsultorio() {
		return idConsultorio;
	}



	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}



	public int getIdDoctor() {
		return idDoctor;
	}



	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}



	public String getHorarioConsulta() {
		return horarioConsulta;
	}



	public void setHorarioConsulta(String horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}



	public String getNombrePaciente() {
		return nombrePaciente;
	}



	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
}
