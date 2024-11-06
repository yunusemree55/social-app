package yecgroup.social_app.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yecgroup.social_app.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	boolean existsUserByEmail(String email);
	boolean existsUserByUsername(String username);
}
