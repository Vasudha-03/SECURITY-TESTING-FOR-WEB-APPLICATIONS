package org.jsp.springBoot.Dao;

import java.time.LocalDate; 
import java.util.List;
import java.util.Optional;

import org.jsp.springBoot.Entity.Department;
import org.jsp.springBoot.Entity.Doctor;
import org.jsp.springBoot.Entity.User;
import org.jsp.springBoot.Exception.NoRecordAvailableException;
import org.jsp.springBoot.Repository.DepartmentRepository;
import org.jsp.springBoot.Repository.DoctorRepository;
import org.jsp.springBoot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorDao {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Doctor save(Doctor doctor) {
		Integer departId= doctor.getDepartment().getDepid();
		
		Optional<Department> optDepartment=departmentRepository.findById(departId);
		
		if(!optDepartment.isEmpty()) {
			doctor.setDepartment(optDepartment.get());
			return doctorRepository.save(doctor);
		}else
			throw new NoRecordAvailableException("No doctor record saved");
	}

	public List<Doctor> saveAllDoctor(List<Doctor> doctor) {
		return doctorRepository.saveAll(doctor);
	}
	
	

	public Doctor getDoctorById(Integer id) {
		Optional<Doctor> opt= doctorRepository.findById(id);
		if(!opt.isEmpty()) {
			return opt.get();
		}
		else
			throw new NoRecordAvailableException("Doctor record does not exist");

	}

	public List<Doctor> findDoctorBySpecialization(String specialization) {
		List<Doctor> doctors= doctorRepository.findDoctorBySpecialization(specialization);
				
				if(!doctors.isEmpty()) {
					return doctorRepository.findDoctorBySpecialization(specialization);
				}
				else
					throw new NoRecordAvailableException("No record found with this specialization "+specialization);
	}

	public List<Doctor> getDoctorByDepartment(Integer depId) {
		List<Doctor> doctors= doctorRepository.findByDepartment_Depid(depId);
		
		if(!doctors.isEmpty()) {
			return doctorRepository.findByDepartment_Depid(depId);
		}
		else
			throw new NoRecordAvailableException("No record with department"+depId);
	}

	public List<Doctor> getDoctorByAppointment(@Param("date") LocalDate date) {
		return doctorRepository.findDoctorsWithAppointments();
	}

	public List<Doctor> getDoctorByDays(String day) {
		if(!day.isEmpty()) {
			return doctorRepository.findByAvailableDay(day);
		}
		else
			throw new NoRecordAvailableException("No doctors available on "+day);
	}
	
	public Doctor updateDoctor(Doctor doctor) {

	    if (doctor.getUser() != null) {

	        Long userId = doctor.getUser().getUserId();

	        User user = userRepository.findById(userId).get();

	        doctor.setUser(user);
	    }

	    return doctorRepository.save(doctor);
	}

	public Doctor deleteDoctor(Integer id) {
		Optional<Doctor> opt= doctorRepository.findById(id);
		
		if(!opt.isEmpty()) {
			Doctor doctor= opt.get();
			doctorRepository.delete(doctor);
			return doctor;
		}
		else
			throw new NoRecordAvailableException("No record found to delete");
	}

	public List<Doctor> getDoctorByPatient(Integer patientId) {
		List<Doctor> doc = doctorRepository.findDoctorsByPatientId(patientId);
        if (!doc.isEmpty()) {
            return doc;
        }
        else
        	throw new NoRecordAvailableException("No prescriptions found for patientId: " + patientId);
        
	}
	public List<Doctor> getAllDoctor() {
		return doctorRepository.findAll();
	}

	public Doctor getDoctorByUserId(Long userId) {
		 Optional<Doctor> opt = doctorRepository.findByUserUserId(userId);

		    if(opt.isPresent()) {
		        return opt.get();
		    }
		    else {
		        throw new NoRecordAvailableException("Doctor not found for this user");
		    }
	}

}
