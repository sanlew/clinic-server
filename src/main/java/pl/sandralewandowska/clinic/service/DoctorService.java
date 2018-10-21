package pl.sandralewandowska.clinic.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sandralewandowska.clinic.model.Doctor;
import pl.sandralewandowska.clinic.model.Specialization;
import pl.sandralewandowska.clinic.repository.DoctorRepository;

@Service("doctorService")
public class DoctorService {
	
	private DoctorRepository doctorRepository;
	
	private static final Logger logger = LogManager.getLogger(DoctorService.class);
	
	@Autowired
	public DoctorService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	public List<Doctor> findAllDoctors() {
		List<Doctor> doctors = new ArrayList<>();
		doctorRepository.findAll().forEach(doctors::add);
		return doctors;
	}
	
	public List<Doctor> findAllDoctorsBySpecialization(Specialization specialization){
		List<Doctor> doctors = new ArrayList<>();
		doctorRepository.findBySpecialization(specialization).forEach(doctors::add);
		return doctors;
	}
	
	public Doctor createDoctor(Doctor doctor) {
		Doctor newDoctor = new Doctor();
		newDoctor.setFirstName(doctor.getFirstName());
		newDoctor.setLastName(doctor.getLastName());
		newDoctor.setSpecialization(doctor.getSpecialization());
		return doctorRepository.save(newDoctor);
	}
	
	public Doctor updateDoctor(Doctor doctorDb, Doctor doctor) {
		
		doctorDb.setFirstName(doctor.getFirstName());
		doctorDb.setLastName(doctor.getLastName());
		doctorDb.setSpecialization(doctor.getSpecialization());
		return doctorRepository.save(doctorDb);
	}
	

}
