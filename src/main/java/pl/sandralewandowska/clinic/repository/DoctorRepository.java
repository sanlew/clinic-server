package pl.sandralewandowska.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import pl.sandralewandowska.clinic.model.Doctor;
import pl.sandralewandowska.clinic.model.Specialization;

public interface DoctorRepository extends CrudRepository<Doctor, Long>{
	
	Iterable<Doctor> findBySpecialization(Specialization specialization);
}
