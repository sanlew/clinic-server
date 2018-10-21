package pl.sandralewandowska.clinic.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.sandralewandowska.clinic.exception.ResourceNotFoundException;
import pl.sandralewandowska.clinic.model.Doctor;
import pl.sandralewandowska.clinic.model.Specialization;
import pl.sandralewandowska.clinic.repository.DoctorRepository;
import pl.sandralewandowska.clinic.repository.SpecializationRepository;
import pl.sandralewandowska.clinic.service.DoctorService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/public/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private SpecializationRepository specializationRepository;
	
	public DoctorController(DoctorRepository doctorRepository, DoctorService doctorService, 
			SpecializationRepository specializationRepository) {
		this.doctorRepository = doctorRepository;
		this.doctorService = doctorService;
		this.specializationRepository = specializationRepository;
	}
	
	 @GetMapping
	 public Iterable<Doctor> getAllDoctors(){
		 return doctorRepository.findAll();
	 }
	 
	 @GetMapping("/{id_doctor}")
	 public Doctor getDoctorById(@PathVariable("id_doctor") Long idDoctor){
		 return doctorRepository.findById(idDoctor).orElse(null);
	 }
	 
	 
	 @GetMapping("/{id_specialization}/list")
	  public Iterable<Doctor> getDoctorsBySpecialization(@PathVariable("id_specialization") Long idSpecialization){
		Optional<Specialization> specialization = specializationRepository.findById(idSpecialization);
		 
		if(specialization.isPresent()) {
			return  doctorRepository.findBySpecialization(specialization.get());
		 }
		return null;
	 }
	 
	 @PostMapping("/new")
	 public void saveDoctor(@RequestBody Doctor doctor) {
		 doctorService.createDoctor(doctor);
	 }
	 
	 @PutMapping("/edit/{id_doctor}")
	 public Doctor updateDoctor(@PathVariable("id_doctor") Long idDoctor, @RequestBody Doctor doctor) {
		 Optional<Doctor> dbDoctor = doctorRepository.findById(idDoctor);
		  return Optional.ofNullable(dbDoctor).map(d -> doctorService.updateDoctor(d.get(), doctor))
	        		.<ResourceNotFoundException>orElseThrow(() ->{throw new ResourceNotFoundException("Not found doctor with id: "+idDoctor);});
		  }
	
}
