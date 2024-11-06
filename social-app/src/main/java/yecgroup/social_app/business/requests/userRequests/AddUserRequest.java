package yecgroup.social_app.business.requests.userRequests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.utilities.ProjectConstant;
import yecgroup.social_app.core.utilities.UserValidationConstant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
	
	
	@Email(regexp = ProjectConstant.emailRegex,message = UserValidationConstant.emailMessage)
	@NotBlank()
	private String email;
	
	@Size(min=3, message = UserValidationConstant.usernameMessage)
	@NotBlank()
	private String username;
	
	@Size(min = 5,message = UserValidationConstant.passwordMessage)
	@NotBlank()
	private String password;
	
	@NotBlank()
	private String confirmPassword;

}
