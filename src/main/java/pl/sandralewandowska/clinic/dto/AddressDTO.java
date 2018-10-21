package pl.sandralewandowska.clinic.dto;

public class AddressDTO {
	private Long id;

	private Integer typeAddressCode;
	
	private String street;
	
	private String houseNr;
	
	private String apartmentNr;
	
	private String postalCode;

	private String city;

	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTypeAddressCode() {
		return typeAddressCode;
	}

	public void setTypeAddressCode(Integer typeAddressCode) {
		this.typeAddressCode = typeAddressCode;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
