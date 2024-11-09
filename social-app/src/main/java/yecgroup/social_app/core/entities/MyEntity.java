package yecgroup.social_app.core.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class MyEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "createdAt",updatable = false)
	@CreationTimestamp 
	private LocalDateTime createdAt;
	
	@Column(name = "updatedAt")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@Column(name = "deletedAt")
	@Nullable 
	private LocalDateTime deletedAt;
	
	
	
	 
	
	

}
