package yecgroup.social_app.business.abstracts;

import java.io.IOException;
import java.util.List;

import yecgroup.social_app.business.requests.postRequests.AddPostRequest;
import yecgroup.social_app.business.requests.postRequests.UpdatePostRequest;
import yecgroup.social_app.business.responses.postResponses.GetAllPostResponse;
import yecgroup.social_app.business.responses.postResponses.GetPostResponse;

public interface PostService {
	
	List<GetAllPostResponse> getAll();
	GetPostResponse getById(int id);
	
	void add(AddPostRequest addPostRequest) throws IOException;
	void delete(int id);
	void updateTitleAndContent(UpdatePostRequest updatePostRequest);

}
