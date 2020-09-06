package com.jrp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.LocationRepository;
import com.jrp.pma.entities.Location;

@Service
public class LocationService {

	@Autowired
	LocationRepository locRepo;
	
	public Location save(Location location) {
		return locRepo.save(location);
	}
	
	public List<Location> getAll(){
		return locRepo.findAll();
	}
}
