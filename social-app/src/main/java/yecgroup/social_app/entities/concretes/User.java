package yecgroup.social_app.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.entities.MyEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "users")
public class User extends MyEntity{
	
	
	@Column(name = "email")
	private String email;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "username")
	private String username; 
	
	@Column(name = "password")
	private String password;
	
	@ManyToOne()
	@JoinColumn(name = "statusId")
	private Status status;
	
	@OneToOne(mappedBy = "user")
	private ProfilePhoto profilePhoto;
	
	@ManyToOne()
	@JoinColumn(name = "onlineStatusId")
	private OnlineStatus onlineStatus;
	
	@OneToMany(mappedBy = "followingUser")
	private List<Follower> followers;
	
	@OneToMany(mappedBy = "followerUser")
	private List<Follower> followings;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	@OneToMany(mappedBy = "user")
	private List<Like> likes;

	@OneToMany(mappedBy = "user")
	private List<Comment> comments;

	@OneToMany(mappedBy = "user")
	private List<CommentLike> commentLikes;

	@OneToMany(mappedBy = "user")
	private List<Reply> replies;

}
