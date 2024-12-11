package yecgroup.social_app.business.requests.authRequests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.utilities.ValidationConstant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	
	@NotBlank(message = ValidationConstant.notBlank)
	private String email;
	
	@NotBlank(message = ValidationConstant.notBlank)
	private String password;

}
