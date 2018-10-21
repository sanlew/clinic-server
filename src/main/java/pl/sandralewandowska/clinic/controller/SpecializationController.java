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
import pl.sandralewandowska.clinic.model.Specialization;
import pl.sandralewandowska.clinic.repository.SpecializationRepository;
import pl.sandralewandowska.clinic.service.SpecializationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/public/specializations")
public class SpecializationController {
	
	@Autowired
	SpecializationRepository specializationRepository;	
	
	@Autowired
	SpecializationService specializationService;

	public SpecializationController(SpecializationRepository specializationRepostory, SpecializationService specializationService) {
		this.specializationRepository = specializationRepostory;
		this.specializationService = specializationService;
	}
	
	  @GetMapping
	    public Iterable<Specialization> getAllSpecializtions() {
	    	return specializationRepository.findAll();  
	    	}
	  
	  @GetMapping("/{id_specialization}")
		  public Specialization getSpecializationById(@PathVariable ("id_specialization") Long idSpecialization ) {
			  return specializationRepository.findById(idSpecialization).orElse(null);
		  }
	 
	  @PostMapping("/new")
		 public void saveSpecialization(@RequestBody Specialization specialization) {
			 specializationService.createSpecialization(specialization);
		 }
		 
		 @PutMapping("/edit/{id_specialization}")
		 public Specialization updateDoctor(@PathVariable("id_specialization") Long idSpecialization, @RequestBody Specialization specialization) {
			 Optional<Specialization> dbSpecialization = specializationRepository.findById(idSpecialization);
			  return Optional.ofNullable(dbSpecialization).map(s -> specializationService.updateSpecialization(s.get(), specialization))
		        		.<ResourceNotFoundException>orElseThrow(() ->
		        		{throw new ResourceNotFoundException("Not found specialization with id: "+idSpecialization);});
			  }
		
	  
}
