package yecgroup.social_app.business.rules.followerBusinessRule;

public interface BaseFollowerBusinessRules {
	
	void checkUserIsAlreadyFollowed(int followerId,int followedId);

}
