package yecgroup.social_app.business.rules.likeBusinessRules;

public interface BaseLikeBusinessRules {
	
	void checkPostIfAlreadyLiked(int postId,int userId);

}
