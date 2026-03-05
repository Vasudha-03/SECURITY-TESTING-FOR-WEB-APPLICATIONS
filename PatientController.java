package org.jsp.springBoot.Controller;

import java.util.List;

import org.jsp.springBoot.Dto.ResponseStructure;
import org.jsp.springBoot.Entity.MedicalRecord;
import org.jsp.springBoot.Entity.Patient;
import org.jsp.springBoot.Repository.MedicalRecordRepository;
import org.jsp.springBoot.Repository.PatientRepository;
import org.jsp.springBoot.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hamr/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Patient>> regPatient(@RequestBody Patient patient){
		return patientService.regPatient(patient);
	}
	
	@PostMapping("/all")
	public ResponseEntity<ResponseStructure<List<Patient>>> regAllPatient(@RequestBody List<Patient> patient){
		return patientService.regAllPatient(patient);
	}
	
	//fetch all patient
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Patient>>> getAllPatient(){
		return patientService.getAllPatient();
	}
	
	//update
	@PutMapping
	public ResponseEntity<ResponseStructure<Patient>> updatePatient(@RequestBody Patient patient){
		return patientService.updatePatient(patient);
	}
	
	//fetch by patient id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Patient>> getByPatientID(@PathVariable Integer id){
		return patientService.getByPatientId(id);
	}
	
	//fetch by phone number
	@GetMapping("/phone/{phone}")
	public ResponseEntity<ResponseStructure<Patient>> getByPhone(@PathVariable Long phone){
		return patientService.getByPhone(phone);
	}
	
	//fetch age patient than
	@GetMapping("/age/{age}")
	public ResponseEntity<ResponseStructure<List<Patient>>> getByAgeGreatertThan(@PathVariable Integer age){
		return patientService.getByAgeGreatertThan(age);
	}
	
	//fetch by appointment 
		@GetMapping("/appointment/{appointId}")
		public ResponseEntity<ResponseStructure<List<Patient>>> getByAppointment(@PathVariable Integer appointId){
			return patientService.getByAppointment(appointId);
		}
	
	//fetch by medical record
	@GetMapping("/medicalrecord/{recordId}")
	public ResponseEntity<ResponseStructure<List<Patient>>> getByMedicalRecord(@PathVariable Integer recordId){
		return patientService.getByMedicalRecord(recordId);
	}
	
	//Delete patient info
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable Integer id){
		return patientService.deleteById(id);
	}
	
	@GetMapping("/my-record")
	public List<MedicalRecord> getMyRecord() {

	    Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();

	    String username = auth.getName();

	    Patient patient = PatientRepository
	            .findByUserUsername(username);

	    return MedicalRecordRepository
	            .findByPatient(patient);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<ResponseStructure<Patient>> getPatientByUserId(@PathVariable Long userId){
		return patientService.getPatientByUserId(userId);
	}
}
