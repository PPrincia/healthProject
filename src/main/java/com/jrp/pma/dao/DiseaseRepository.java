package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.entities.Disease;

public interface DiseaseRepository extends CrudRepository<Disease, Long>{

	@Override
	List<Disease> findAll();
}
