package yecgroup.social_app.api;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.PostService;
import yecgroup.social_app.business.requests.postRequests.AddPostRequest;
import yecgroup.social_app.business.requests.postRequests.UpdatePostRequest;
import yecgroup.social_app.business.responses.postResponses.GetAllPostResponse;
import yecgroup.social_app.business.responses.postResponses.GetPostResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/api/posts")
public class PostsController {

	private PostService postService;
	
	@GetMapping("/all")
	public List<GetAllPostResponse> getAll(){
		
		return postService.getAll();
		
	}
	
	@GetMapping("/{id}")
	public GetPostResponse getById(@PathVariable int id) {
		
		return postService.getById(id);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		
		postService.delete(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@ModelAttribute @Valid AddPostRequest addPostRequest) throws IOException {
		
		postService.add(addPostRequest);
	} 
	
	@PutMapping("/update")
	public void updateTitleAndContent(@RequestBody @Valid UpdatePostRequest updatePostRequest) {
		
		postService.updateTitleAndContent(updatePostRequest);
	}
	
}
