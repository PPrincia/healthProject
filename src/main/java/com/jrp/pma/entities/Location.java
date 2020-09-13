package com.jrp.pma.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String province;
	private String district;
	private String sector;
	
	@OneToMany(mappedBy = "locations")
	private List<Patient> patient;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	
	public List<Patient> getPatient() {
		return patient;
	}
	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Location [patient=" + patient + "]";
	}
	public Location(long id, String province, String district, String sector, List<Patient> patient) {
		super();
		this.id = id;
		this.province = province;
		this.district = district;
		this.sector = sector;
		this.patient = patient;
	}
	public Location() {
		
	}
	
	
	
}
