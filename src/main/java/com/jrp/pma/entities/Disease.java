package com.jrp.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Disease {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long diseaseId;
	
	private String name;
	private String category;
	private String severity;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			   fetch = FetchType.LAZY)
	@JoinTable(name="patient_disease",
	joinColumns = @JoinColumn(name="disease_id"),
	inverseJoinColumns = @JoinColumn(name=("patient_id")))
	private List<Patient> patients;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	
	
	public long getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(long diseaseId) {
		this.diseaseId = diseaseId;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public Disease(long diseaseId, String name, String category, String severity) {
		super();
		this.diseaseId = diseaseId;
		this.name = name;
		this.category = category;
		this.severity = severity;
	}
	
	
	public Disease() {
		
	}
	
	
	
}
