package yecgroup.social_app.business.requests.postRequests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostRequest {
	
	private int id;
	
	@NotBlank()
	private String title;
	
	@NotBlank()
	private String content;

}
