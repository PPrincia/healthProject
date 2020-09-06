package com.jrp.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import javax.persistence.JoinColumn;

@Entity
public class Patient {

	@Id
	private String patientId;
	
	@NotNull
	@Size(min = 2, max = 30)
	private String firstName;
	
	@NotBlank
	@Size(min = 2, max = 30)
	private String lastName;
	
	@NotBlank
	private String gender;
	
	@NotBlank
	@Column(unique = true)
	private String phone;
	
	@NotBlank
	private String description;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			   fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	@NotNull
	private Location location;
	
	
	@OneToMany(mappedBy = "patient")
	/*@JoinTable(name="patient_disease",
	joinColumns = @JoinColumn(name="patient_id", referencedColumnName = "patientId",
            nullable = false),
	inverseJoinColumns = @JoinColumn(name="disease_id", referencedColumnName = "diseaseId",
            nullable = false))*/
	private List<Disease> diseases;
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public List<Disease> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Patient(String patientId, String firstName, String lastName, String gender, String phone, String description
			 ) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phone = phone;
		this.description = description;
		
		
	}
	
	
	public Patient() {
		
	}
	
	
}
