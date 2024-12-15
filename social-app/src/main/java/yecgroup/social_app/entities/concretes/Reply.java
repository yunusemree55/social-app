package yecgroup.social_app.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.entities.MyEntity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "replies")
public class Reply extends MyEntity {

    @Column(name = "content")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "commentId")
    private Comment comment;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

}
