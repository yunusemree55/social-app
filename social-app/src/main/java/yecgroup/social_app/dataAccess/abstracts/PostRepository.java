package yecgroup.social_app.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import yecgroup.social_app.entities.concretes.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	@Modifying
	@Transactional
	@Query("UPDATE Post p SET p.title = :title, p.content = :content,p.updatedAt = CURRENT_TIMESTAMP WHERE p.id = :id")
	void updateTitleAndContent(@Param(value = "id") int id,@Param(value = "title") String title,@Param(value = "content") String content);

	@Modifying
	@Transactional
	@Query("UPDATE Post p SET p.status.id = 2, p.deletedAt = CURRENT_TIMESTAMP WHERE p.id = :id")
	void deletePost(int id);

}

