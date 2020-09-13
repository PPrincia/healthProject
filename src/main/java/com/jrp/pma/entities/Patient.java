package com.jrp.pma.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	private Location locations;
	
	
	
	/*@OneToMany(mappedBy = "patient")*/
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			   fetch = FetchType.LAZY)
	@JoinTable(name="patient_disease",
	joinColumns = {@JoinColumn(name="patient_id")},
	inverseJoinColumns = {@JoinColumn(name="disease_id")})
	private List<Disease> diseases;
	

	
	public List<Disease> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}
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

	public Location getLocations() {
		return locations;
	}
	public void setLocations(Location locations) {
		this.locations = locations;
	}
	


	
	public Patient(String patientId, @NotNull @Size(min = 2, max = 30) String firstName,
			@NotBlank @Size(min = 2, max = 30) String lastName, @NotBlank String gender, @NotBlank String phone,
			@NotBlank String description, @NotNull Location locations, List<Disease> diseases) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phone = phone;
		this.description = description;
		this.locations = locations;
		this.diseases = diseases;
	}
	public Patient() {
		
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", locations=" + locations + ", diseases=" + diseases + "]";
	}
	
	
	
	
	
	/*public Patient(@NotNull @Size(min = 2, max = 30) String firstName) {
		super();
		this.firstName = firstName;
	}*/
	
	
	
	/*@JoinTable(name="patient_disease",
	joinColumns = @JoinColumn(name="patient_id", referencedColumnName = "patientId",
            nullable = false),
	inverseJoinColumns = @JoinColumn(name="disease_id", referencedColumnName = "diseaseId",
            nullable = false))*/
}
