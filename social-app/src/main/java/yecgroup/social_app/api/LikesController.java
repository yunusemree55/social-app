package yecgroup.social_app.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.LikeService;
import yecgroup.social_app.business.requests.likeRequests.AddLikeRequest;

@RestController
@AllArgsConstructor
@RequestMapping("/api/likes")
public class LikesController {
	
	private LikeService likeService;
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddLikeRequest addLikeRequest) {
		
		likeService.add(addLikeRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		likeService.delete(id);
	}

}
