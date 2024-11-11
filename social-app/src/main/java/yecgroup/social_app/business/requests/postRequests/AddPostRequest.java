package yecgroup.social_app.business.requests.postRequests;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPostRequest {
	
	private int userId;
	
	@NotBlank()
	private String title;
	
	@NotBlank()
	private String content;

	private MultipartFile photoFile;
	

}
