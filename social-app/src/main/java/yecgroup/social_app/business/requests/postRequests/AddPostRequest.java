package yecgroup.social_app.business.requests.postRequests;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.utilities.ValidationConstant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPostRequest {
	
	private int userId;
	
	@NotBlank(message = ValidationConstant.notBlank)
	private String title;
	
	@NotBlank(message = ValidationConstant.notBlank)
	private String content;

	private MultipartFile photoFile;
	

}
