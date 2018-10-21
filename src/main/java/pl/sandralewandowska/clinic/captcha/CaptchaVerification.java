package pl.sandralewandowska.clinic.captcha;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pl.sandralewandowska.clinic.exception.InvalidRecaptchaException;

@Service("captchaVerification")
public class CaptchaVerification {

	 	@Autowired
	    private CaptchaSettings captchaSettings;

	 	public void verify(String response) {
       
        URI verifyUri = URI.create(String.format(
          "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s",
          captchaSettings.getSecret(), response));
        
        RestTemplate restTemplate = new RestTemplate();
        GoogleResponse googleResponse = restTemplate.getForObject(verifyUri, GoogleResponse.class);
 
        if(!googleResponse.isSuccess()) {
            throw new InvalidRecaptchaException();
        }
    }
    

}
