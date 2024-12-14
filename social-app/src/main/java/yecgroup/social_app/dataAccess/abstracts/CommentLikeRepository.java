package yecgroup.social_app.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import yecgroup.social_app.entities.concretes.CommentLike;

public interface CommentLikeRepository extends JpaRepository<CommentLike,Integer> {

    boolean existsByCommentIdAndUserId(int commentId, int userId);


}
