package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrp.pma.dao.DiseaseRepository;
import com.jrp.pma.dao.LocationRepository;
import com.jrp.pma.dao.PatientRepository;
import com.jrp.pma.dto.PatientDiseaseList;
import com.jrp.pma.dto.PatientLocationList;
import com.jrp.pma.entities.Disease;
import com.jrp.pma.entities.Location;
import com.jrp.pma.entities.Patient;

@Controller
public class HomeController {

	@Autowired
	LocationRepository locRepo;
	
	@Autowired
	DiseaseRepository disRepo;
	
	@Autowired
	PatientRepository patRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Location> locations = locRepo.findAll();
		List<Disease> diseases = disRepo.findAll();
		List<Patient> patients = patRepo.findAll();
		model.addAttribute("locationsList", locations);
		model.addAttribute("diseasesList", diseases);
		model.addAttribute("patientsList", patients);
		
		
		List<PatientLocationList> patientLocationCnt = patRepo.patientLo();
		model.addAttribute("patientListLocationCnt", patientLocationCnt);
		
		List<PatientDiseaseList> patientDiseaseCnt = patRepo.patientDis();
		model.addAttribute("patientListDiseaseCnt", patientDiseaseCnt);
		
		return "main/home";
		
	}
}
