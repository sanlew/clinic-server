package pl.sandralewandowska.clinic.enums;

public enum AddressType {
	
	REGISTERED (0,"RegisteredAddress"),
	LIVE (1, "LiveAddress"),
	CORRESPONDENCE (2, "CorrespondenceAddress"),
	TEMPORARY (3, "TemporaryAddress");
	
	private Integer code;
	private String description;
	
	AddressType(Integer code, String description){
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static AddressType findByCode(Integer code) {
		for(AddressType aT:AddressType.values()) {
			if(aT.getCode()==code) {
				return aT;
			}
		}
		return null;
	}
}
