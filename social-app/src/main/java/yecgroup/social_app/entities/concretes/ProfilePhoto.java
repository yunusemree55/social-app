package yecgroup.social_app.entities.concretes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.entities.abstracts.Photo;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="profilePhotos")
public class ProfilePhoto{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="photoId")
	private Photo photo;
	
	@OneToOne()
	@JoinColumn(name = "userId")
	private User user; 
	
	

}
