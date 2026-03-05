package org.jsp.springBoot.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springBoot.Entity.Patient;
import org.jsp.springBoot.Entity.User;
import org.jsp.springBoot.Exception.NoRecordAvailableException;
import org.jsp.springBoot.Repository.PatientRepository;
import org.jsp.springBoot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDao {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private UserRepository userRepository;
	
	public Patient regPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public List<Patient> regAllPatient(List<Patient> patient) {
		return patientRepository.saveAll(patient);
	}

	public List<Patient> getAllPatient() {
		List<Patient> patients = patientRepository.findAll();
		
		if(!patients.isEmpty()) {
			return patientRepository.findAll();
		}
		else
			throw new NoRecordAvailableException("No patient record found");
	}

	public Patient updatePatient(Patient patient) {
		
		if(patient.getPatientId()==null) {
			throw new NoRecordAvailableException("Pass the existing patient id to update the record");
		}
		
		Optional<Patient> opt= patientRepository.findById(patient.getPatientId());
		
		if(!opt.isEmpty()) {
			if(patient.getUser()!=null) {
				Long userId= patient.getUser().getUserId();
				Optional<User> optUser=userRepository.findById(userId);
				
				if(!opt.isEmpty()) {
					User user=optUser.get();
					patient.setUser(user);
				}
				else {
					throw new NoRecordAvailableException("User not found");
			}
			}
			return patientRepository.save(patient);
		}
		else
			throw new NoRecordAvailableException("No patient is present to update");
	}

	public Patient getByPatient(Integer id) {
		Optional<Patient> opt= patientRepository.findById(id);
		
		if(!opt.isEmpty()) {
			return opt.get();
		}
		else
			throw new NoRecordAvailableException("No Patient with "+id);
	}

	public Patient getByPhone(Long phone) {
		Optional<Patient> opt= patientRepository.findByPhone(phone);
				
				if(!opt.isEmpty()) {
					return opt.get();
				}
				else
					throw new NoRecordAvailableException("No patient record found with this no. "+phone);
	}

	public List<Patient> getByAgeGreatertThan(Integer age) {

		List<Patient> patients= patientRepository.findByAgeGreaterThan(age);
		
		if(!patients.isEmpty()) {
			return patientRepository.findByAgeGreaterThan(age);
		}
		else
			throw new NoRecordAvailableException("No patient found age greater than "+age);
	}

	public List<Patient> getByMedicalRecord(Integer recordId) {
		List<Patient> patients= patientRepository.findByMedicalRecord_recordId(recordId);
		
		if(!patients.isEmpty()) {
			return patientRepository.findByMedicalRecord_recordId(recordId);
		}
		else
			throw new NoRecordAvailableException("No patient found "+recordId);
	}
	
	public Patient deleteById(Integer id) {
		Optional<Patient> opt= patientRepository.findById(id);
		
		if(!opt.isEmpty()) {
			Patient patient= opt.get();
			patientRepository.delete(patient);
			return patient;
		}
		else
			throw new NoRecordAvailableException("No record found to delete");
	}

	public List<Patient> getByAppointment(Integer appointId) {
		List<Patient> patients= patientRepository.findByAppointment_appointId(appointId);
		
		if(!patients.isEmpty()) {
			return patientRepository.findByAppointment_appointId(appointId);
		}
		else
			throw new NoRecordAvailableException("No patient found "+appointId);
	}

	public Patient getPatientByUserId(Long userId) {
		Optional<Patient> opt= patientRepository.findByUserUserId(userId);
		
		if(!opt.isEmpty()) {
			return opt.get();
		}
		else
			throw new NoRecordAvailableException("No patient found");
	}
	
	
}