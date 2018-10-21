package pl.sandralewandowska.clinic.model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pl.sandralewandowska.clinic.enums.AddressType;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@SequenceGenerator(initialValue=1, allocationSize = 1, name="new_seq_address", sequenceName="address_id_seq")
	@GeneratedValue(strategy = SEQUENCE ,generator="new_seq_address")
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name="typeAddress", nullable=false)
	private AddressType typeAddress;
	
	@Column(name = "street", length = 30)
	private String street;
	
	@Column(name = "house_nr", length = 5)
	private String houseNr;
	
	@Column(name = "apartment_nr", length = 5)
	private String apartmentNr;
	
	@Column(name = "postal_code", length = 6, nullable = false)
	private String postalCode;

	@Column(name = "city", length = 30, nullable = false)
	private String city;

	@Column(name = "country", length = 30, nullable = false)
	private String country;
	
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "id")})
	private User user;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressType getTypeAddress() {
		return typeAddress;
	}

	public void setTypeAddress(AddressType typeAddress) {
		this.typeAddress = typeAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNr() {
		return houseNr;
	}

	public void setHouseNr(String houseNr) {
		this.houseNr = houseNr;
	}

	public String getApartmentNr() {
		return apartmentNr;
	}

	public void setApartmentNr(String apartmentNr) {
		this.apartmentNr = apartmentNr;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("city=[").append(city).append("] ");
		buffer.append("street=[").append(street).append("] ");
		buffer.append("homeNr=[").append(houseNr).append("] ");
		buffer.append("apartmentNr=[").append(apartmentNr).append("] ");
		buffer.append("postalCode=[").append(postalCode).append("] ");
		buffer.append("country=[").append(country).append("] ");

		return buffer.toString();
	}
	


}
