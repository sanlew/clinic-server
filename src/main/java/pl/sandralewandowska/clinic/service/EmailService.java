package pl.sandralewandowska.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import pl.sandralewandowska.clinic.dto.UserDTO;
import pl.sandralewandowska.clinic.model.User;

@Service("emailService")
public class EmailService {

	private JavaMailSender mailSender;
	
	@Autowired
	public EmailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@Async
	public void sendEmail(SimpleMailMessage email) {
		mailSender.send(email);
	}

	@Async
	public void sendConfirmationEmail(String email, String token) {
		
		String appUrl = "localhost:4200";
		SimpleMailMessage registrationEmail = new SimpleMailMessage();
		registrationEmail.setTo(email);
		registrationEmail.setSubject("Registration Confirmation");
		registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
				+ appUrl + "/confirm?token=" + token);
		registrationEmail.setFrom("noreply@domain.com");
		mailSender.send(registrationEmail);
	}
}
