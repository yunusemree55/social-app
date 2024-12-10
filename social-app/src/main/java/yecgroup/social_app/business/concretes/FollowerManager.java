package yecgroup.social_app.business.concretes;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.FollowerService;
import yecgroup.social_app.business.requests.followerRequests.AddFollowerRequest;
import yecgroup.social_app.business.rules.followerBusinessRule.BaseFollowerBusinessRules;
import yecgroup.social_app.dataAccess.abstracts.FollowerRepository;
import yecgroup.social_app.entities.concretes.Follower;
import yecgroup.social_app.entities.concretes.User;

@Service
@AllArgsConstructor
public class FollowerManager implements FollowerService {
	
	private FollowerRepository followerRepository;
	private BaseFollowerBusinessRules baseFollowerBusinessRules;
	
	

	@Override
	public void add(AddFollowerRequest addFollowerRequest) {
		
		baseFollowerBusinessRules.checkUserIsAlreadyFollowed(addFollowerRequest.getFollowerUserId(), addFollowerRequest.getFollowingUserId());
		
		Follower follower = new Follower();	
		follower.setId(0);
		
		follower.setFollowerUser(new User());
		follower.setFollowingUser(new User());
		
		follower.getFollowerUser().setId(addFollowerRequest.getFollowerUserId());
		follower.getFollowingUser().setId(addFollowerRequest.getFollowingUserId());

		followerRepository.save(follower);

	}



	@Override
	public void remove(int id) {
		
		followerRepository.deleteById(id);
		
	}

	

	

}
