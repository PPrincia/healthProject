package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.pma.dao.LocationRepository;
import com.jrp.pma.dao.PatientRepository;
import com.jrp.pma.entities.Disease;
import com.jrp.pma.entities.Location;
import com.jrp.pma.entities.Patient;
import com.jrp.pma.services.LocationService;
import com.jrp.pma.services.PatientService;

@Controller
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	LocationService locService;
	
	@Autowired
	LocationRepository locRepo;
	
	@Autowired
	PatientRepository patRepo;
	
	@Autowired
	PatientService patService;
	
	@GetMapping
	public String displayLocations(Model model) {
		
		List<Patient> patients = patRepo.findAll();
		List<Location> locations = locService.getAll();
		model.addAttribute("allLocations", patients);
		model.addAttribute("locations", locations);
		return "locations/location-list";
		
	}
	
	@GetMapping("/new")
	public String displayLocationForm(Model model) {
			Location aLocation = new Location();
			model.addAttribute("location", aLocation);
			List<Patient> patiient = patService.getAll();
			model.addAttribute("allPatients", patiient);
			
			return "locations/new-location";
		}
	
	
	@PostMapping("/save")
	public String createLocation(Location location, @RequestParam List<String> patient, BindingResult bindingResult, Model model) {
		
		Iterable<Patient> choosenPatients = patRepo.findAllByPatientIdIn(patient);
		for(Patient patie:choosenPatients) {
			patie.setLocations(location);
			patRepo.save(patie);
		

			
		locRepo.save(location);
		
		
	}
		return "redirect:/locations";
	
	
	}
	
}
