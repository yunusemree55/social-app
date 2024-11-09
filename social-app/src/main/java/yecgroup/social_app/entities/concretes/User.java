package yecgroup.social_app.entities.concretes;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@DynamicUpdate
@Table(name = "users")
public class User extends MyEntity{
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "username")
	private String username; 
	
	@Column(name = "password")
	private String password;
	
	@ManyToOne()
	@JoinColumn(name = "statusId")
	private Status status;
	
	@OneToOne(mappedBy = "user")
	private ProfilePhoto profilePhoto;

}
