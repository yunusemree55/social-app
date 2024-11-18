package yecgroup.social_app.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.UserService;
import yecgroup.social_app.business.requests.userRequests.AddUserRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserEmailRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserOnlineStatusRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserPasswordRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserUsernameRequest;
import yecgroup.social_app.business.responses.userResponses.GetAllUserResponse;
import yecgroup.social_app.business.responses.userResponses.GetUserResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;
	
	
	@GetMapping("/all")
	public List<GetAllUserResponse> getAll() {
		
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetUserResponse getUserById(@PathVariable int id) {
		
		return userService.getUserById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid AddUserRequest addUserRequest) {
		
		userService.add(addUserRequest);
	}
	
	@PutMapping("/update-email")
	public void update(@RequestBody @Valid UpdateUserEmailRequest updateUserEmailRequest) {
		
		userService.updateEmail(updateUserEmailRequest);
		
	}
	
	@PutMapping("/update-username")
	public void updateUsername(@RequestBody @Valid UpdateUserUsernameRequest updateUserUsernameRequest) {
		
		userService.updateUsername(updateUserUsernameRequest);
	}
	
	@PutMapping("/update-password")
	public void updatePassword(UpdateUserPasswordRequest updateUserPasswordRequest) {
		
		userService.updatePassword(updateUserPasswordRequest);
	}
	
	public void updateOnlineStatus(UpdateUserOnlineStatusRequest updateUserOnlineStatusRequest) {
		
		userService.updateOnlineStatus(updateUserOnlineStatusRequest);
	}

}
