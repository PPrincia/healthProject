package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jrp.pma.entities.Location;
import com.jrp.pma.entities.Patient;

public interface LocationRepository extends CrudRepository<Location, Long>{
	
	@Override
	public List<Location> findAll();

}
