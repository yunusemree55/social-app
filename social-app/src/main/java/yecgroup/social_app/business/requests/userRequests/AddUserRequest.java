package yecgroup.social_app.business.requests.userRequests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
	
	
	@Email(regexp = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",message = "This is not a properly formatted email address.")
	@NotBlank()
	private String email;
	
	@Size(min=3, message = "Username's length should be more than 3 characters")
	@NotBlank()
	private String username;
	
	@Size(min = 5,message = "Password's length should be more than 5 characters")
	@NotBlank()
	private String password;
	
	@NotBlank()
	private String confirmPassword;

}
