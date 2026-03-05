package org.jsp.springBoot.Service;

import java.util.List;

import org.jsp.springBoot.Dao.PatientDao;
import org.jsp.springBoot.Dto.ResponseStructure;
import org.jsp.springBoot.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

	@Autowired
	private PatientDao patientDao;

	public ResponseEntity<ResponseStructure<Patient>> regPatient(Patient patient) {
		ResponseStructure<Patient> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Patient as registered");
		response.setData(patientDao.regPatient(patient));
		
		return new ResponseEntity<ResponseStructure<Patient>>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Patient>>> regAllPatient(List<Patient> patient) {

		ResponseStructure<List<Patient>> response=new ResponseStructure<>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("All patient record registered");
		response.setData(patientDao.regAllPatient(patient));
		
		return new ResponseEntity<ResponseStructure<List<Patient>>>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Patient>>> getAllPatient() {
		ResponseStructure<List<Patient>> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("All patient records found");
		response.setData(patientDao.getAllPatient());
		
		return new ResponseEntity<ResponseStructure<List<Patient>>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Patient>> updatePatient(Patient patient) {
		ResponseStructure<Patient> response=new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Patient record is updated");
		response.setData(patientDao.updatePatient(patient));
		
		return new ResponseEntity<ResponseStructure<Patient>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Patient>> getByPatientId(Integer id) {

		ResponseStructure<Patient> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Patient found with "+id);
		response.setData(patientDao.getByPatient(id));
		
		return new ResponseEntity<ResponseStructure<Patient>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Patient>> getByPhone(Long phone) {
		ResponseStructure<Patient> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Patient found with "+phone);
		response.setData(patientDao.getByPhone(phone));
		
		return new ResponseEntity<ResponseStructure<Patient>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Patient>>> getByAgeGreatertThan(Integer age) {
		ResponseStructure<List<Patient>> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Patient found with age greater than "+age);
		response.setData(patientDao.getByAgeGreatertThan(age));
		
		return new ResponseEntity<ResponseStructure<List<Patient>>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Patient>>> getByMedicalRecord(Integer recordId) {
		ResponseStructure<List<Patient>> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Patient found withmedical record "+recordId);
		response.setData(patientDao.getByMedicalRecord(recordId));
		
		return new ResponseEntity<ResponseStructure<List<Patient>>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(Integer id) {
		patientDao.deleteById(id);
		ResponseStructure<String> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Patient record "+id+" is deleted");
		response.setData("Success");
		
		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Patient>>> getByAppointment(Integer appointId) {
		ResponseStructure<List<Patient>> response= new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Patient found withmedical record "+appointId);
		response.setData(patientDao.getByAppointment(appointId));
		
		return new ResponseEntity<ResponseStructure<List<Patient>>>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Patient>> getPatientByUserId(Long userId) {
		ResponseStructure<Patient> response=new ResponseStructure<>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Patient found with user: "+userId);
		response.setData(patientDao.getPatientByUserId(userId));
		
		return new ResponseEntity<ResponseStructure<Patient>>(response, HttpStatus.OK);
	}
}
