package pl.sandralewandowska.clinic.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@SequenceGenerator(initialValue=1, allocationSize = 1,  name="new_seq_user", sequenceName="user_id_seq")
	@GeneratedValue(strategy = SEQUENCE ,generator="new_seq_user")
	@Column( name="id", nullable=false )
	private Long id;
	
	@Column( name="email", nullable=false, length=255 )
	private String email;
	
	@Column( name="firstName", nullable=false, length=255 )
	private String firstName;
	
	@Column( name="lastName", nullable=false, length=255 )
	private String lastName;
	
	@Column( name="password", nullable=false, length=255)
	private String password;
	
	@Column( name="registerDate" )
	private Date registerDate;
	
	@Column( name="confirmed" )
	private Boolean confirmed;

	@Column( name="confirmationToken" )
	private String confirmationToken;
	
	@Column( name="active" )
	private Boolean active;
	
	@Column( name="changedPassword" )
	private Boolean changedPassword;

	@Column( name="dateLastChange" )
	private Date dateLastChange;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getChangedPassword() {
		return changedPassword;
	}

	public void setChangedPassword(Boolean changedPassword) {
		this.changedPassword = changedPassword;
	}

	public Date getDateLastChange() {
		return dateLastChange;
	}

	public void setDateLastChange(Date dateLastChange) {
		this.dateLastChange = dateLastChange;
	}


	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("firstName=[").append(firstName).append("] ");
		buffer.append("lastName=[").append(lastName).append("] ");
		buffer.append("registerDate=[").append(registerDate).append("] ");
		buffer.append("confirmed=[").append(confirmed).append("] ");
		buffer.append("active=[").append(active).append("] ");
		buffer.append("changedPassword=[").append(changedPassword).append("] ");
		

		return buffer.toString();
	}

	
}
