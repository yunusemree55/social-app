package yecgroup.social_app.api;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.UserService;
import yecgroup.social_app.business.requests.userRequests.AddUserRequest;
import yecgroup.social_app.business.responses.userResponses.GetAllUserResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;
	
	
	@GetMapping("/all")
	public List<GetAllUserResponse> getAll() {
		
		return userService.getAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid AddUserRequest addUserRequest) {
		
		userService.add(addUserRequest);
	}

}
