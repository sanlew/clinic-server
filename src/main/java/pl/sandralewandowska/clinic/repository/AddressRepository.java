package pl.sandralewandowska.clinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.sandralewandowska.clinic.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

	List<Address> findByUserId(Long userId);

	

}
