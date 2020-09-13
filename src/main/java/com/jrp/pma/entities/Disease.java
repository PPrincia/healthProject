package com.jrp.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Disease {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long diseaseId;
	
	@NotBlank
	private String name;
	@NotBlank
	private String category;
	@NotBlank
	private String severity;
	
	/*@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			   fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")*/
	
	
	@ManyToMany(mappedBy = "diseases")
	@NotNull
	private List<Patient> patient;
	
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
	 
	public List<Patient> getPatient() {
		return patient;
	}
	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	public long getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(long diseaseId) {
		this.diseaseId = diseaseId;
	}
	
	public Disease(long diseaseId, String na, String category, String severity) {
		super();
		this.diseaseId = diseaseId;
		this.name = na;
		this.category = category;
		this.severity = severity;
	}
	
	public Disease() {
		
	}
	
	
	@Override
	public String toString() {
		return name;
	}
	
	
	
	
}
