package org.jsp.springBoot.Service;

import java.time.LocalDate;
import java.util.List; 

import org.jsp.springBoot.Dao.DoctorDao;
import org.jsp.springBoot.Dto.ResponseStructure;
import org.jsp.springBoot.Entity.Doctor;
import org.jsp.springBoot.Repository.DepartmentRepository;
import org.jsp.springBoot.Repository.DoctorRepository;
import org.jsp.springBoot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.autoconfigure.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(Doctor doctor){
		ResponseStructure<Doctor> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Doctor record is saved");
		response.setData(doctorDao.save(doctor));
		
		return new ResponseEntity<ResponseStructure<Doctor>>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Doctor>>> saveAllDoctor(List<Doctor> doctor) {
		
		ResponseStructure<List<Doctor>> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("All records of doctor is found");
		response.setData(doctorDao.saveAllDoctor(doctor));
		
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Doctor>> getDoctorById(Integer id) {
		ResponseStructure<Doctor> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Doctor found ");
		response.setData(doctorDao.getDoctorById(id));
		
		return new ResponseEntity<ResponseStructure<Doctor>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorBySpecialization(String specialization) {

		ResponseStructure<List<Doctor>> response=new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Doctor found with the specialization "+specialization);
		response.setData(doctorDao.findDoctorBySpecialization(specialization));
		
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByDepartment(Integer depId) {
		ResponseStructure<List<Doctor>> response=new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Doctor is found by the department "+depId);
		response.setData(doctorDao.getDoctorByDepartment(depId));
		
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.OK);
	}


//	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByPatient(String patient) {
//		ResponseStructure<List<Doctor>> response=new ResponseStructure<>();
//		response.setStatusCode(HttpStatus.OK.value());
//		response.setMessage("Doctor is found by the department "+patient);
//		response.setData(doctorDao.getDoctorByPatient(patient));
//		
//		return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.OK);
//	}
	
	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorAppointment(LocalDate date) {

		ResponseStructure<List<Doctor>> response=new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Doctor found  with appointment");
		response.setData(doctorDao.getDoctorByAppointment(date));
		
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByDays(String day) {
		ResponseStructure<List<Doctor>> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Doctor is available on "+day);
		response.setData(doctorDao.getDoctorByDays(day));
		
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(Doctor doctor){
		ResponseStructure<Doctor> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Doctor record is updated");
		response.setData(doctorDao.save(doctor));
		
		return new ResponseEntity<ResponseStructure<Doctor>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Doctor>> deleteDoctor(Integer id) {
		ResponseStructure<Doctor> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Doctor record "+id+" is deleted");
		response.setData(doctorDao.deleteDoctor(id));
		
		return new ResponseEntity<ResponseStructure<Doctor>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByPatient(Integer patientId) {
		ResponseStructure<List<Doctor>> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Doctor record is deleted");
		response.setData(doctorDao.getDoctorByPatient(patientId));
		
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDoctor() {
		ResponseStructure<List<Doctor>> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("All Doctor record is found");
		response.setData(doctorDao.getAllDoctor());
		
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Doctor>> getDoctorByUserId(Long userId){
		ResponseStructure<Doctor> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Doctor found with user: "+userId);
		response.setData(doctorDao.getDoctorByUserId(userId));
		
		return new ResponseEntity<ResponseStructure<Doctor>>(response, HttpStatus.OK);
	}
//	User user= userRepository.findById(doctor.getUser().getId()).get();
//	doctor.setUser(user);
//	doctorRepository.save(user);
}
