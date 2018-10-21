package pl.sandralewandowska.clinic.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceExistsException extends RuntimeException {
	

	private static final long serialVersionUID = 3632237324369283635L;

	public ResourceExistsException() {
	   super("User with email exist");
	}
	
	public ResourceExistsException(String email) {
		   super("User with email:"+email+" exist");
			}
	   
}
