package yecgroup.social_app.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.entities.MyEntity;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment extends MyEntity {

    @Column(name = "content")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "comment")
    private List<CommentLike> commentLikes;

}
