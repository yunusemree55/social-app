package yecgroup.social_app.business.responses.userResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserForLoginResponse {
	
	private String email;
	private String password;

}
