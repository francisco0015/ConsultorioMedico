package com.consultorio.core.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.consultorio.core.configuration.Pages;
import com.consultorio.core.model.Citas;
import com.consultorio.core.model.Consultorios;
import com.consultorio.core.model.Doctor;

@Controller
@RequestMapping("/home")
public class ControllerBasic {
	ArrayList<Citas> citasMedicas = new ArrayList<>();
	ArrayList<Doctor> doctores = new ArrayList<>();
	ArrayList<Consultorios> consultorios = new ArrayList<>();
	
	
	public ControllerBasic() {
		this.citasMedicas = new ArrayList<>();
		this.doctores = new ArrayList<>();
		this.consultorios = new ArrayList<>();

		this.doctores.add(new Doctor(1, "Doctor a", "Apellido Materno", "Apellido paterno", "Cardiologo"));
		this.doctores.add(new Doctor(2, "Doctor b", "Apellido Materno", "Apellido paterno", "Neurologo"));
		this.doctores.add(new Doctor(3, "Doctor c", "Apellido Materno", "Apellido paterno", "Traumatologo"));
		this.doctores.add(new Doctor(4, "Doctor d", "Apellido Materno", "Apellido paterno", "Anestesiologo"));
		this.doctores.add(new Doctor(5, "Doctor e", "Apellido Materno", "Apellido paterno", "Urologo"));
		
		this.consultorios.add(new Consultorios(1, 1));
		this.consultorios.add(new Consultorios(2, 1));
		this.consultorios.add(new Consultorios(3, 1));
	}

	@GetMapping(path = {"/index","/"})
	public String home(Model model) {
		//model.addAttribute("posts", this.getPosts());
		return "index";
	}
	
	@GetMapping("/listCitas")
	public ModelAndView getCitas() {
		return new ModelAndView(Pages.CITAS).addObject("citas", this.citasMedicas);
	}
	
	@GetMapping("/newCita")
	public ModelAndView getForm() {
		return new ModelAndView(Pages.FORM).addObject("cita", new Citas()).addObject("consultorios", this.consultorios);
	}
	
	@PostMapping("/addNewCita")
	public String addNewCita(Citas cita, Model model) {
		List<Citas> citas = this.citasMedicas;
		if(citaIsValid(cita.getIdConsultorio(), cita.getIdDoctor(), cita.getHorarioConsulta(), cita.getNombrePaciente())) 
			citas.add(cita);
		else {
			System.out.println("La cita que intenta agendar no es valida, verifique que se cumpla los requisitos solitados.");
		}
		
		model.addAttribute("citas", citas);
		return "index";
	}
	
	// No se puede agendar cita en un mismo consultorio a la misma hora
	// No se puede agendar cita para un mismo doctor a la misma 
	// No se puede agendar cita para un paciente a la una misma hora ni con menos de 2 horas 
	// de diferencia para el mismo día. Es decir, si un paciente tiene 1 cita de 2 a 3pm, solo 
	// podría tener otra el mismo día a partir de las 5pm.
	// Un mismo doctor no puede tener más de 8 citas en el día
	public boolean citaIsValid(int idConsultorio, int idDoctor, String horarioConsulta, String nombrePaciente) {
		boolean isValid = true;
		int contConsultas = 0;

		for(int i = 0; i<this.citasMedicas.size(); i++){
			if(this.citasMedicas.get(i).getIdDoctor() == idDoctor) contConsultas++;
			if((this.citasMedicas.get(i).getIdConsultorio() == idConsultorio && this.citasMedicas.get(i).getHorarioConsulta().equals(horarioConsulta)) || 
					(this.citasMedicas.get(i).getIdDoctor() == idDoctor && this.citasMedicas.get(i).getHorarioConsulta().equals(horarioConsulta)) || 
					(this.citasMedicas.get(i).getNombrePaciente().equals(nombrePaciente) && this.citasMedicas.get(i).getHorarioConsulta().equals(horarioConsulta))) isValid = false;
		}
		

		if(contConsultas > 8) return false;

		return isValid;
	}
}
