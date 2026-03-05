package org.jsp.springBoot.Repository;

import java.util.List;
import java.util.Optional;

import org.jsp.springBoot.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

	Optional<Patient> findByPhone(Long phone);

	List<Patient> findByAgeGreaterThan(Integer age);

	List<Patient> findByMedicalRecord_recordId(Integer recordId);

	List<Patient> findByAppointment_appointId(Integer appointId);

	static Patient findByUserUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	Optional<Patient> findByUserUserId(Long userId);
}
