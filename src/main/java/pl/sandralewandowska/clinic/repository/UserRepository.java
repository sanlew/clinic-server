package pl.sandralewandowska.clinic.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pl.sandralewandowska.clinic.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	 Optional<User> findByEmailIgnoreCase(String email);

}
