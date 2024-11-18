package yecgroup.social_app.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.AuthService;
import yecgroup.social_app.business.requests.authRequests.LoginRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserOnlineStatusRequest;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auths")
public class AuthsController {
	
	private AuthService authService;
	
	@PostMapping("/login")
	public boolean login(@RequestBody @Valid LoginRequest loginRequest) {
		
		return authService.login(loginRequest); 
		
	}
	
	@PostMapping("/logout")
	public void logout(@RequestBody @Valid UpdateUserOnlineStatusRequest updateUserOnlineStatusRequest) {
		
		authService.logout(updateUserOnlineStatusRequest);
		
	}

}
