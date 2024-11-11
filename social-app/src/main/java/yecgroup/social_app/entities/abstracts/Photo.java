package yecgroup.social_app.entities.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.entities.MyEntity;
import yecgroup.social_app.entities.concretes.Post;
import yecgroup.social_app.entities.concretes.ProfilePhoto;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "photos")
public class Photo extends MyEntity{
	
	@Column(name="src")
	private String src;
	
	@OneToOne(mappedBy = "photo")
	private ProfilePhoto profilePhoto;

	@OneToOne(mappedBy = "photo")
	private Post post;
}

