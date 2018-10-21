package pl.sandralewandowska.clinic.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class AccessToken {

	@Id
	@Column(name = "autentication_id", nullable = false)
	private String autenticationId;
	
	@Column(name = "token_id", nullable = false)
	private String tokenId;
	
	@Column(name = "token", nullable = false)
	private Long token;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "client_id")
	private String clientId;
	
	@Column(name = "authentication")
	private Long authentication;
	
	@Column(name = "refresh_token")
	private String refreshToken;
	
	
	
	
}
