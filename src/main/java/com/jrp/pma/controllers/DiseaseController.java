package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.DiseaseRepository;
import com.jrp.pma.entities.Disease;
import com.jrp.pma.entities.Patient;
import com.jrp.pma.services.DiseaseService;
import com.jrp.pma.services.PatientService;

@Controller
@RequestMapping("/diseases")
public class DiseaseController {

	@Autowired
	DiseaseService disService;
	
	@Autowired
	DiseaseRepository disRepo;
	
	@Autowired
	PatientService patService;
	
	@GetMapping
	public String displayDiseases(Model model) {
		
		List<Disease> diseases = disService.getAll();
		
		model.addAttribute("diseases", diseases);
		
		return "diseases/disease-list";
		
	}
	
	@GetMapping("/new")
	public String displayDiseaseForm(Model model) {
		
		Disease aDisease = new Disease();
		List<Patient> patients = patService.getAll();
		model.addAttribute("disease", aDisease);
		model.addAttribute("allPatients", patients);
		return "diseases/new-disease";
	}
	
	@PostMapping("/save")
	public String createDisease(Disease disease,BindingResult bindingResult, Model model) {
		
		disRepo.save(disease);
		
		return "redirect:/diseases";
	}
}
