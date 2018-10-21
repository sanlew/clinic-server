package pl.sandralewandowska.clinic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.sandralewandowska.clinic.dto.UserDTO;
import pl.sandralewandowska.clinic.model.User;
import pl.sandralewandowska.clinic.repository.UserRepository;

@Service("userService")
public class UserService {

	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	private UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	

	public User createUser(UserDTO user) {
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		newUser.setPassword(encryptedPassword);
		
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setConfirmed(false);
		newUser.setChangedPassword(false);
		newUser.setActive(true);
		newUser.setRegisterDate(new Date());
		newUser.setConfirmationToken(UUID.randomUUID().toString());
		return userRepository.save(newUser);
	}
	

	
	public User changePassword(User dbUser, UserDTO user) {
		User updateUser = dbUser;
		String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		updateUser.setPassword(encryptedPassword);
		//updateUser.setChangedPassword(user.getChangedPassword());
		logger.debug("Update pass for user: "+ updateUser.toString());
		return userRepository.save(updateUser);
	}
	
	public User activateUser(User dbUser, boolean active) {
		User updateUser = dbUser;
		updateUser.setActive(active);
		logger.debug("Update active for user: "+ updateUser.toString());
		return userRepository.save(updateUser);
	}
	
	public User confirmUser(User dbUser, boolean confirmed) {
		User updateUser = dbUser;
		updateUser.setConfirmed(confirmed);
		logger.debug("Update active for user: "+ updateUser.toString());
		return userRepository.save(updateUser);
	}
	
	public List<User> findAllUsers() {
		List<User> users= new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
}
