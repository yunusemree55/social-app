package yecgroup.social_app.business.requests.profilePhotoRequests;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfilePhotoRequest {
	
	private int id;
	private MultipartFile file;

}
