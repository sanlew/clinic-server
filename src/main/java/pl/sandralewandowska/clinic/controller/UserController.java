package pl.sandralewandowska.clinic.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.sandralewandowska.clinic.captcha.CaptchaVerification;
import pl.sandralewandowska.clinic.dto.UserDTO;
import pl.sandralewandowska.clinic.exception.ResourceExistsException;
import pl.sandralewandowska.clinic.exception.ResourceNotFoundException;
import pl.sandralewandowska.clinic.model.User;
import pl.sandralewandowska.clinic.repository.UserRepository;
import pl.sandralewandowska.clinic.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {

	  	private final Logger log = LoggerFactory.getLogger(UserController.class);
	    private final UserRepository userRepository;
	    private final UserService userService;
	   // private final EmailService emailService;
	    private CaptchaVerification captchaVerification;

	    public UserController(UserRepository userRepository, UserService userService, CaptchaVerification captchaVerification) {

	        this.userRepository = userRepository;
	        this.userService = userService;
	        this.captchaVerification = captchaVerification;
	    }
	    
	    @GetMapping
	    public List<User> getAllUsers() {
	    	return userService.findAllUsers();
	    }
	    
	    @GetMapping("/{userId}")
	    public User getUser(@PathVariable("userId") Long userId) {
	    	return userRepository.findById(userId).orElse(null);
	    }
	    
	   
	    @PostMapping("/new")
	    @ResponseStatus(HttpStatus.CREATED)
		public void  createUser(@RequestBody UserDTO user, @RequestParam(name="response") String recaptchaResponse) {
	    	captchaVerification.verify(recaptchaResponse);
			userRepository.findByEmailIgnoreCase(user.getEmail())
			.ifPresent(u -> {throw new ResourceExistsException("User with login: "+user.getEmail()+" exist");});
	   	  	User createdUser = userService.createUser(user);
	   	  //	emailService.sendConfirmationEmail(createdUser.getLogin(), createdUser.getConfirmationToken());
		}
	    
//	    @PutMapping("/{userId}")
//	    public User updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
//	    	Optional<User> dbUser = userRepository.findById(userId);
//	    	Optional.ofNullable(dbUser).map(u -> userService.updateUser(u.get(), user))
//	    	.orElseThrow(() ->{throw new ResourceNotFoundException("Not found user with id: "+user.getId());});
//	    	
//	    }
	    
	    @GetMapping("/me")
	    public User currentUser() {
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    	return userRepository.findByEmailIgnoreCase(authentication.getName()).orElse(null);
	        
	    }

	    
	    @PutMapping("/confirmation/{userId}")
	    public void confirmUser(@PathVariable("userId") Long userId, @RequestBody User user) {
	    	Optional<User> dbUser = userRepository.findById(userId);
	    	Optional.ofNullable(dbUser).map(u -> userService.confirmUser(u.get(), true))
	    	.<ResourceNotFoundException>orElseThrow(() ->
	    	{throw new ResourceNotFoundException("Not found user with id: "+user.getId());});
	    	
	    }
	    
//	    @PutMapping("changePassword/{userId}")
//	    public void changePassword(@PathVariable("userId") Long userId, @RequestBody String password) {
//	    	Optional<User> dbUser = userRepository.findById(userId);
//	    	Optional.ofNullable(dbUser).map(u -> userService.confirmUser(u.get(), true))
//	    	.<ResourceNotFoundException>orElseThrow(() ->
//	    	{throw new ResourceNotFoundException("Not found user with id: "+userId);});
//	    	
//	    }
	    
	    @DeleteMapping("/{userId}")
	    public void deleteUser(@PathVariable("userId") Long userId, @RequestBody User user) {
			if (!userRepository.findById(user.getId()).isPresent()) {
				throw new ResourceNotFoundException("Not found person with id: "+user.getId());
			}
			userRepository.delete(user);
				}
	    
}
