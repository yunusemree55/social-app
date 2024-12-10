package yecgroup.social_app.entities.concretes;

import java.util.List;

import jakarta.persistence.CascadeType;
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
import yecgroup.social_app.entities.abstracts.Photo;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post extends MyEntity{
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne()
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "photoId")
	private Photo photo;
	
	@ManyToOne
	@JoinColumn(name = "statusId")
	private Status status;
	
	@OneToMany(mappedBy = "post")
	private List<Like> likes;


}
