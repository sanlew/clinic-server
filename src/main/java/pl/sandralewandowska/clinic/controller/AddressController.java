package pl.sandralewandowska.clinic.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.sandralewandowska.clinic.model.Address;
import pl.sandralewandowska.clinic.service.AddressService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/data")
public class AddressController {
	

	@Autowired
	AddressService addressService;
	
	  public AddressController(AddressService addressService) {
		    this.addressService = addressService;
		}
	  @GetMapping("/address")
	  public Iterable<Address> getAllAddresses()  {
	    return addressService.findAll();
	  }
	  
	  @GetMapping("/{personId}/address")
	  public List<Address> getAddressesForPerson(@PathVariable("personId") Long personId) {
	    return addressService.findByPersonId(personId);
	  }
	  
	  @GetMapping("/{personId}/address/{addressId}")
	  public Address getAddressById(@PathVariable("personId") Long personId, @PathVariable("addressId") Long addressId) {
	    return addressService.findById(addressId).orElse(null);
	  }
	  
//	  @PostMapping //("/{personId}/address/new")
//	  public Address createAddress(@RequestBody Address address) {
//		  //return addressService.save(address);
//	  }
	  
	  @PutMapping("/{personId}/address/{id}")
	  public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody Address address) {
		    return new ResponseEntity<>("Address has been updated!", HttpStatus.OK);
	  }

	  @DeleteMapping("/{personId}/address/{id}")
	  public ResponseEntity<String> delete(@PathVariable("id") Long id) {
			    Address address = addressService.findById(id).orElse(null);
			    if (address != null) {
			    	addressService.delete(address);
			    }
			    return new ResponseEntity<>("Address has been deleted!", HttpStatus.OK);
			}
	
}
