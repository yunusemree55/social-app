package yecgroup.social_app.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import yecgroup.social_app.entities.concretes.Reply;

public interface ReplyRepository extends JpaRepository<Reply,Integer> {
}
