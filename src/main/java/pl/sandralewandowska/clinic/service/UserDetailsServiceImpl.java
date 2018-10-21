package pl.sandralewandowska.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.sandralewandowska.clinic.model.User;
import pl.sandralewandowska.clinic.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userRepository.findByEmailIgnoreCase(login).orElse(null);
		
		UserBuilder builder = null;
	    if (user != null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(login);
	      builder.password(user.getPassword());
	      builder.authorities("USER");
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }

	    return builder.build();
	}
}
