package com.jrp.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.pma.dao.DiseaseRepository;
import com.jrp.pma.dao.PatientRepository;
import com.jrp.pma.entities.Disease;
import com.jrp.pma.entities.Location;
import com.jrp.pma.entities.Patient;
import com.jrp.pma.services.DiseaseService;
import com.jrp.pma.services.LocationService;
import com.jrp.pma.services.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	PatientService patService;
	
	@Autowired
	PatientRepository patRepo;
	
	@Autowired
	DiseaseService disService;
	
	@Autowired
	DiseaseRepository disRepo;
	
	@Autowired
	LocationService locService;
	
	@GetMapping
	public String displayPatients(Model model) {
		
		List<Patient> patients = patService.getAll();
		model.addAttribute("patients", patients);
		
		return "patients/patient-list";
	}
	
	@GetMapping("/new")
	public String displayPatientForm(Model model) {
		
		Patient aPatient = new Patient();
		List<Disease> diseases = disService.getAll();
		List<Location> locations = locService.getAll();
		model.addAttribute("patient", aPatient);
		model.addAttribute("allDiseases", diseases);
		model.addAttribute("allLocations", locations);
		return "patients/new-patient";
	}
	
	@PostMapping("/save")
	public String createPatient(Model model, @Valid Patient patient, @RequestParam List<Long> diseases ){
		
		Iterable<Disease> choosenDiseases = disRepo.findAllById(diseases);
		for(Disease dis:choosenDiseases) {
			dis.setPatient(patient);
			disRepo.save(dis);
		}
		
		patRepo.save(patient);
		
		return "redirect:/patients";
	}
}
