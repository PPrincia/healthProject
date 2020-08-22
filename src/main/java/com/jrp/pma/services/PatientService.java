package com.jrp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.PatientRepository;
import com.jrp.pma.entities.Patient;

@Service
public class PatientService {

	@Autowired
	PatientRepository patRepo;
	
	public Patient save(Patient patient) {
		return patRepo.save(patient);
	}
	
	public List<Patient> getAll(){
		return patRepo.findAll();
	}
}
