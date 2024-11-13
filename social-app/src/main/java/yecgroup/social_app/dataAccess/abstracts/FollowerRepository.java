package yecgroup.social_app.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import yecgroup.social_app.entities.concretes.Follower;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {
	
	
	@Query("SELECT CASE WHEN count(f)>0 THEN TRUE ELSE FALSE END FROM Follower f WHERE f.followerUser.id = :followerId AND f.followingUser.id = :followingId")
	boolean isUserAlreadyFollowed(@Param(value = "followerId") int followerId,@Param(value = "followingId") int followingId);
	
	
	List<Follower> findByFollowerUserId(int followerId);
	List<Follower> findByFollowingUserId(int followingId); 
}
