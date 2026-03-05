package org.jsp.springBoot.Controller;

import java.time.LocalDate;
import java.util.List;

import org.jsp.springBoot.Dto.ResponseStructure;
import org.jsp.springBoot.Entity.Doctor;
import org.jsp.springBoot.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hamr/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(@RequestBody Doctor doctor){
		return doctorService.saveDoctor(doctor);
	}
	
	//post all the inputs
	@PostMapping("/all")
	public ResponseEntity<ResponseStructure<List<Doctor>>> saveAllDoctor(@RequestBody List<Doctor> doctor){
		return doctorService.saveAllDoctor(doctor);
	}
	
	//fetch doctor by doctor id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Doctor>> getDoctorById(@PathVariable Integer id){
		return doctorService.getDoctorById(id);
	}
	
	//fetch doctor by specialization
	@GetMapping("/specialization/{specialization}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorBySpecialization(@PathVariable String specialization){
		return doctorService.getDoctorBySpecialization(specialization);
	}
	
	//fetch doctor in a department
	@GetMapping("/department/{depId}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByDepartment(@PathVariable Integer depId){
		return doctorService.getDoctorByDepartment(depId);
	}
	
	//Fetch doctor by patient
	@GetMapping("/patient/{patientId}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByPatient(@PathVariable Integer patientId){
		return doctorService.getDoctorByPatient(patientId);
	}
	
	@GetMapping("/appointment/{date}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByAppointment( @PathVariable
	        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	        LocalDate date){
		return doctorService.getDoctorAppointment(date);
	}
	
	//fetch doctor by availableDays
	@GetMapping("/availabelDays/{day}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByDays(@PathVariable String day){
		return doctorService.getDoctorByDays(day);
	}
	
	//update doctor info
	@PutMapping
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(@RequestBody Doctor doctor){
		return doctorService.updateDoctor(doctor);
	}
	
	//delete doctor
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Doctor>> deleteDoctor(@PathVariable Integer id){
		return doctorService.deleteDoctor(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDcotor(){
		return doctorService.getAllDoctor();
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<ResponseStructure<Doctor>> getDoctorByUserID(@PathVariable Long userId){
		return doctorService.getDoctorByUserId(userId);
	}
}
