package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.dao.PatientRepository;
import com.jrp.pma.entities.Location;
import com.jrp.pma.entities.Patient;
import com.jrp.pma.services.LocationService;

@Controller
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	LocationService locService;
	
	@Autowired
	PatientRepository patRepo;
	
	@GetMapping
	public String displayLocations(Model model) {
		
		List<Location> locations = locService.getAll();
		List<Patient> patients = patRepo.findAll();
		model.addAttribute("locations", locations);
		model.addAttribute("allLocations", patients);
		return "locations/location-list";
		
	}
	
	@GetMapping("/new")
	public String displayLocationForm(Model model) {
			Location aLocation = new Location();
			model.addAttribute("location", aLocation);
			
			
			return "locations/new-location";
		}
	
	
	@PostMapping("/save")
	public String createLocation(Location location, BindingResult bindingResult, Model model) {
		
		locService.save(location);
		
		return "redirect:/locations";
	}
	
	
	
	
	
}
