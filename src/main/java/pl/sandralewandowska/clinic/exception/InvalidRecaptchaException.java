package pl.sandralewandowska.clinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED)
public class InvalidRecaptchaException extends RuntimeException {
	

	private static final long serialVersionUID = 3632237324369283635L;

	public InvalidRecaptchaException() {
	   super("Recaptcha was not successfully validated");
	}
	
}
