package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.PatientDiseaseList;
import com.jrp.pma.dto.PatientLocationList;
import com.jrp.pma.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, String>{

	@Override
	public List<Patient> findAll();
	
	
	@Query(nativeQuery = true, value = "SELECT p.first_name as firstName, p.last_name as lastName,  COUNT(pl.patient_id) as PatientLocation \r\n" + 
			"FROM patient p left join patient_location pl on pl.patient_id = p.patient_id\r\n" + 
			"GROUP BY p.first_name, p.last_name ORDER BY 3  DESC")
	public List<PatientLocationList> patientLo();
	
	@Query(nativeQuery = true, value = "SELECT p.first_name as firstName, p.last_name as lastName,  COUNT(de.patient_id) as PatientDisease\r\n" + 
			"FROM patient p left join patient_disease de on de.patient_id = p.patient_id\r\n" + 
			"GROUP BY p.first_name, p.last_name ORDER BY 3  DESC")
	public List<PatientDiseaseList> patientDis();


	public Patient findByPatientId(String value);


	public Patient findPatientByPhone(String value);


	


	


}
