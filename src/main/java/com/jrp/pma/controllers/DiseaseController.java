package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.entities.Disease;
import com.jrp.pma.services.DiseaseService;

@Controller
@RequestMapping("/diseases")
public class DiseaseController {

	@Autowired
	DiseaseService disService;
	
	@GetMapping
	public String displayDiseases(Model model) {
		
		List<Disease> diseases = disService.getAll();
		model.addAttribute("diseases", diseases);
		
		return "diseases/disease-list";
		
	}
	
	@GetMapping("/new")
	public String displayDiseaseForm(Model model) {
		
		Disease aDisease = new Disease();
		model.addAttribute("disease", aDisease);
		
		return "diseases/new-disease";
	}
	
	@PostMapping("/save")
	public String createDisease(Disease disease,BindingResult bindingResult, Model model) {
		
		disService.save(disease);
		
		return "redirect:/diseases";
	}
}
