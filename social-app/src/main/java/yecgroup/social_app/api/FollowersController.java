package yecgroup.social_app.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.FollowerService;
import yecgroup.social_app.business.requests.followerRequests.AddFollowerRequest;

@RestController
@AllArgsConstructor
@RequestMapping("/api/followers")
public class FollowersController {
	
	private FollowerService followerService;
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddFollowerRequest addFollowerRequest) {
		
		followerService.add(addFollowerRequest);
	}

}
