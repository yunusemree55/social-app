package yecgroup.social_app.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import yecgroup.social_app.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);
	Optional<User> findByEmail(String email);
	
	boolean existsUserByEmail(String email); 
	boolean existsUserByUsername(String username);
	
	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.email = :email, u.updatedAt = CURRENT_TIMESTAMP WHERE u.id = :id")
	void updateEmail(@Param(value = "id") int id,@Param(value = "email") String email);
	
	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.username = :username, u.updatedAt = CURRENT_TIMESTAMP WHERE u.id = :id")
	void updateUsername(@Param(value = "id") int id,@Param(value = "username") String username);
	
	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.password = :password, u.updatedAt = CURRENT_TIMESTAMP WHERE u.id = :id")
	void updatePassword(@Param(value = "id") int id,@Param(value = "password") String password);
	
	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.onlineStatus.id = :onlineStatusId WHERE u.id = :id")
	void updateOnlineStatus(@Param(value = "id") int id,@Param(value = "onlineStatusId") int onlineStatusId);
}
 