package yecgroup.social_app.business.requests.userRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.utilities.UserValidationConstant;
import yecgroup.social_app.core.utilities.ValidationConstant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserUsernameRequest {
	
	private int id;
	
	@Size(min=3, message = UserValidationConstant.usernameMessage)
	@NotBlank(message = ValidationConstant.notBlank)
	private String username;

}
