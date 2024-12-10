package yecgroup.social_app.business.rules.likeBusinessRules;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import yecgroup.social_app.business.abstracts.LikeService;
import yecgroup.social_app.core.exceptions.BusinessException;
import yecgroup.social_app.core.utilities.ExceptionMessageConstant;

@Service
public class LikeBusinessRules implements BaseLikeBusinessRules{
	
	@Lazy
	@Autowired
	private LikeService likeService;

	@Override
	public void checkPostIfAlreadyLiked(int postId,int userId) {
		
		boolean isAlreadyLiked = likeService.isAlreadyLiked(postId,userId);
		
		if(isAlreadyLiked) {
			throw new BusinessException(ExceptionMessageConstant.likeErrorMessage);
		}
		
		
	}

}
