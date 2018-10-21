package pl.sandralewandowska.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sandralewandowska.clinic.model.Specialization;
import pl.sandralewandowska.clinic.repository.SpecializationRepository;

@Service("specialiationService")
public class SpecializationService {
	

	private SpecializationRepository specializationRepository;
	
	@Autowired
	public SpecializationService(SpecializationRepository specializationRepository) {
		this.specializationRepository = specializationRepository;
	}
	
	public Specialization createSpecialization(Specialization specialization) {
		Specialization newSpecialization = new Specialization();
		newSpecialization.setName(specialization.getName());
		newSpecialization.setDescription(specialization.getDescription());
		return specializationRepository.save(newSpecialization);
	}
	
	public Specialization updateSpecialization(Specialization specializationDb, Specialization specialization) {
		
		specializationDb.setName(specialization.getName());
		specializationDb.setDescription(specialization.getDescription());
		return specializationRepository.save(specializationDb);
	}

}
