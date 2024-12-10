package yecgroup.social_app.business.abstracts;

import yecgroup.social_app.business.requests.likeRequests.AddLikeRequest;

public interface LikeService {
	
	void add(AddLikeRequest addLikeRequest);
	void delete(int id);
	
	boolean isAlreadyLiked(int postId,int userId);

}
