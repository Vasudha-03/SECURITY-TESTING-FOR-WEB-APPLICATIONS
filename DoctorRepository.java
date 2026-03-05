package org.jsp.springBoot.Repository;

import java.util.List;
import java.util.Optional;

import org.jsp.springBoot.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	List<Doctor> findDoctorBySpecialization(String specialization);
	
	List<Doctor> findByDepartment_Depid(Integer depId);
	
	@Query("select distinct a.doctor from Appointment a")
	List<Doctor> findDoctorsWithAppointments();
	
	@Query("SELECT d FROM Doctor d WHERE d.availableDays LIKE %:day%")
	List<Doctor> findByAvailableDay(String day);

	@Query("SELECT a.doctor FROM Appointment a WHERE a.patient.patientId = :patientId")
	List<Doctor> findDoctorsByPatientId(@Param("patientId") Integer patientId);
	
	Optional<Doctor> findByUserUserId(Long userId);
}
