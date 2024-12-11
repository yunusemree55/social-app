package yecgroup.social_app.business.requests.userRequests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.utilities.ProjectConstant;
import yecgroup.social_app.core.utilities.UserValidationConstant;
import yecgroup.social_app.core.utilities.ValidationConstant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
	
	
	@Email(regexp = ProjectConstant.emailRegex,message = UserValidationConstant.emailMessage)
	@NotBlank(message = ValidationConstant.notBlank)
	private String email;

	@Size(min=2, message = UserValidationConstant.firstNameMessage)
	@NotBlank(message = ValidationConstant.notBlank)
	private String firstName;

	@Size(min=2, message = UserValidationConstant.lastNameMessage)
	@NotBlank(message = ValidationConstant.notBlank)
	private String lastName;
	
	@Size(min=3, message = UserValidationConstant.usernameMessage)
	@NotBlank(message = ValidationConstant.notBlank)
	private String username;
	
	@Size(min = 5,message = UserValidationConstant.passwordMessage)
	@NotBlank(message = ValidationConstant.notBlank)
	private String password;
	
	@NotBlank(message = ValidationConstant.notBlank)
	private String confirmPassword;

}
