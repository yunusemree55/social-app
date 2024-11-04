package yecgroup.social_app.entities.abstracts;

import java.util.Date;
import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.entities.concretes.User;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "baseUsers")
public class BaseUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "createdAt")
	private Date createdAt;
	
	@Column(name = "updatedAt")
	@Nullable
	private Date updatedAt;
	
	@Column(name = "deletedAt")
	@Nullable
	private Date deletedAt;
	
	@OneToMany(mappedBy = "baseUser")
	private List<User> users;

}
