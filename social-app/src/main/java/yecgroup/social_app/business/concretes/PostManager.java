package yecgroup.social_app.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.PostService;
import yecgroup.social_app.business.requests.postRequests.AddPostRequest;
import yecgroup.social_app.business.requests.postRequests.UpdatePostRequest;
import yecgroup.social_app.business.responses.postResponses.GetAllPostResponse;
import yecgroup.social_app.business.responses.postResponses.GetPostResponse;
import yecgroup.social_app.core.adapters.imageKit.ImageKitService;
import yecgroup.social_app.core.utilities.mapper.modelMapper.ModelMapperService;
import yecgroup.social_app.dataAccess.abstracts.PostRepository;
import yecgroup.social_app.entities.abstracts.Photo;
import yecgroup.social_app.entities.concretes.Post;
import yecgroup.social_app.entities.concretes.Status;

@Service
@AllArgsConstructor
public class PostManager implements PostService {
	
	private PostRepository postRepository;
	private ImageKitService imageKitService;
	private ModelMapperService modelMapperService;
	
	
	@Override
	public List<GetAllPostResponse> getAll() {

		List<GetAllPostResponse> postResponseList = postRepository.findAll().stream()
				.map(post -> modelMapperService.forResponse().map(post, GetAllPostResponse.class))
				.collect(Collectors.toList());

		return postResponseList;
	}
	
	@Override
	public GetPostResponse getById(int id) {
		
		Post target = postRepository.findById(id).orElseThrow();

		GetPostResponse postResponse = modelMapperService.forResponse().map(target, GetPostResponse.class);
		
		return postResponse;
		
	}
	

	@Override
	public void add(AddPostRequest addPostRequest) throws IOException {
		
		Post post = modelMapperService.forRequest().map(addPostRequest, Post.class);
		post.setId(0);
		
		String src = imageKitService.upload(addPostRequest.getPhotoFile());
		
		post.setPhoto(new Photo());
		post.setStatus(new Status());
		post.getPhoto().setSrc(src);
		post.getStatus().setId(1);
		
		
		postRepository.save(post); 

	}
	
	@Override
	public void delete(int id) {
		
		postRepository.deletePost(id);
			
	}

	@Override
	public void updateTitleAndContent(UpdatePostRequest updatePostRequest) {
		
		postRepository.updateTitleAndContent(updatePostRequest.getId(), updatePostRequest.getTitle(), updatePostRequest.getContent());
		
	}

	


	


	

}
