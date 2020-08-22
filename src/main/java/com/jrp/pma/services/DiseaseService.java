package com.jrp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.DiseaseRepository;
import com.jrp.pma.entities.Disease;

@Service
public class DiseaseService {

	@Autowired
	DiseaseRepository disRepo;
	
	public Disease save(Disease disease) {
		return disRepo.save(disease);
	}
	
	public List<Disease> getAll() {
		return disRepo.findAll();
	}
}
