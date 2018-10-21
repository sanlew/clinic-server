package pl.sandralewandowska.clinic.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class RefreshToken {
	
	@Id
	@Column(name="token_id", nullable=false)
	 private String tokenId;
	@Column(name="token")
	 private Long token;
	@Column(name="authentication")
	 private Long authentication;

}
