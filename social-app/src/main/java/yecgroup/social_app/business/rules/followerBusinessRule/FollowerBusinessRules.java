package yecgroup.social_app.business.rules.followerBusinessRule;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yecgroup.social_app.core.exceptions.BusinessException;
import yecgroup.social_app.core.utilities.BusinessRuleConstant;
import yecgroup.social_app.dataAccess.abstracts.FollowerRepository;

@Service
@AllArgsConstructor
public class FollowerBusinessRules implements BaseFollowerBusinessRules {
	
	private FollowerRepository followerRepository;

	@Override
	public void checkUserIsAlreadyFollowed(int followerId, int followedId) {
		boolean isAlreadyFollower = followerRepository.isUserAlreadyFollowed(followerId, followedId);
		
		if(isAlreadyFollower) {
			
			throw new BusinessException(BusinessRuleConstant.userIsAlreadyFollowed);
		}
		
		
		
	}

}
