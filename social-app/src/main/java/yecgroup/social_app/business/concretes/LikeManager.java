package yecgroup.social_app.business.concretes;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.LikeService;
import yecgroup.social_app.business.requests.likeRequests.AddLikeRequest;
import yecgroup.social_app.business.rules.likeBusinessRules.BaseLikeBusinessRules;
import yecgroup.social_app.core.utilities.mapper.modelMapper.ModelMapperService;
import yecgroup.social_app.dataAccess.abstracts.LikeRepository;
import yecgroup.social_app.entities.concretes.Like;

@Service
@AllArgsConstructor
public class LikeManager implements LikeService{
	
	private LikeRepository likeRepository;
	private ModelMapperService modelMapperService;
	private BaseLikeBusinessRules baseLikeBusinessRules;
	
	@Override
	public void add(AddLikeRequest addLikeRequest) {
		
		baseLikeBusinessRules.checkPostIfAlreadyLiked(addLikeRequest.getPostId(),addLikeRequest.getUserId());
		
		Like like = modelMapperService.forRequest().map(addLikeRequest, Like.class);
		
		
		likeRepository.save(like);
		
	}
	
	@Override
	public void delete(int id) {
		
		likeRepository.deleteById(id);
		
	}
	
	@Override
	public boolean isAlreadyLiked(int postId,int userId) {
		
		return likeRepository.existsByPostIdAndUserId(postId,userId); 
		
	}
}
