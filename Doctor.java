package org.jsp.springBoot.Entity;

import java.util.List; 

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer docId;

	private String docName;
	private String specialization;
	private String availableDays;

	@JsonIgnore
	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointment;

	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	private List<MedicalRecord> medicalRecord;

	@ManyToOne
	@JoinColumn(name="depid")
	private Department department;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAvailableDays() {
		return availableDays;
	}

	public void setAvailableDays(String availableDays) {
		this.availableDays = availableDays;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	public List<MedicalRecord> getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(List<MedicalRecord> medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
}
