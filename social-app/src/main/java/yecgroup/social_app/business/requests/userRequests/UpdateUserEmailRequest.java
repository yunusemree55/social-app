package yecgroup.social_app.business.requests.userRequests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.utilities.ProjectConstant;
import yecgroup.social_app.core.utilities.UserValidationConstant;
import yecgroup.social_app.core.utilities.ValidationConstant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserEmailRequest {
	
	private int id;
	
	@Email(regexp = ProjectConstant.emailRegex,message = UserValidationConstant.emailMessage)
	@NotBlank(message = ValidationConstant.notBlank)
	private String email;

}
