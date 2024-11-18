package yecgroup.social_app.business.requests.authRequests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;

}
