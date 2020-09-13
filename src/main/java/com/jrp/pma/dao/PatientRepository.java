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
	
	
	@Query(nativeQuery = true, value = "SELECT p.first_name as firstName, p.last_name as lastName, p.location_id  as PatientLocation\r\n" + 
			"FROM patient p")
	public List<PatientLocationList> patientLo();
	
	@Query(nativeQuery = true, value = "SELECT d.disease_id as DiseaseId, d.patient_id as PatientId, p.first_name as FirstName , p.last_name as LastName\r\n" + 
			"FROM patient_disease d left join patient p on d.patient_id = p.patient_id")
	public List<PatientDiseaseList> patientDis();


	//public Patient findByPatientId(String value);


	//public Patient findPatientByPhone(String value);


	public List<Patient> findAllByPatientIdIn(List<String> patients);


	//public Iterable<Patient> findByPatientId(List<Long> patients);


	


	


	


}
