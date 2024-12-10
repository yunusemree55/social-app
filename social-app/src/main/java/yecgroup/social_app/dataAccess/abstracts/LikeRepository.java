package yecgroup.social_app.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yecgroup.social_app.entities.concretes.Like;

public interface LikeRepository extends JpaRepository<Like, Integer>{
	
	
	boolean existsByPostIdAndUserId(int postId,int userId);

}
