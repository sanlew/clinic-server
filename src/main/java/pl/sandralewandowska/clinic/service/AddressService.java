package pl.sandralewandowska.clinic.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sandralewandowska.clinic.dto.AddressDTO;
import pl.sandralewandowska.clinic.enums.AddressType;
import pl.sandralewandowska.clinic.model.Address;
import pl.sandralewandowska.clinic.model.User;
import pl.sandralewandowska.clinic.repository.AddressRepository;

@Service("addressService")
public class AddressService {
	
	private AddressRepository addressRepository;
	
	private static final Logger logger = LogManager.getLogger(AddressService.class);
	
	@Autowired
	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	public List<Address> findByPersonId(Long userId){
		return addressRepository.findByUserId(userId);
	}
	
	public Optional<Address> findById(Long addressId) {
		return addressRepository.findById(addressId);
	}
	
	public Address save(AddressDTO addressDTO, User user) {
		Address newAddress = new Address();
		newAddress.setTypeAddress(AddressType.findByCode(addressDTO.getTypeAddressCode()));
		newAddress.setStreet(addressDTO.getStreet());
		newAddress.setHouseNr(addressDTO.getHouseNr());
		newAddress.setApartmentNr(addressDTO.getApartmentNr());
		newAddress.setPostalCode(addressDTO.getPostalCode());
		newAddress.setCity(addressDTO.getCity());
		newAddress.setCountry(addressDTO.getCountry());
		newAddress.setUser(user);
    	logger.debug("Create new address: "+ addressDTO.toString());
		return addressRepository.save(newAddress);
	}

	public void delete(Address address) {
		addressRepository.delete(address);
	}
	
	public Iterable<Address> findAll() {
		return addressRepository.findAll();
	}

}
