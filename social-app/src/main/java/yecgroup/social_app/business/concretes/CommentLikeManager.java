package yecgroup.social_app.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yecgroup.social_app.business.abstracts.CommentLikeService;
import yecgroup.social_app.business.requests.commentLikeRequests.AddCommentLikeRequest;
import yecgroup.social_app.business.rules.commentLikeBusinessRules.BaseCommentLikeBusinessRules;
import yecgroup.social_app.core.utilities.mapper.modelMapper.ModelMapperService;
import yecgroup.social_app.dataAccess.abstracts.CommentLikeRepository;
import yecgroup.social_app.entities.concretes.CommentLike;

@Service
@AllArgsConstructor
public class CommentLikeManager implements CommentLikeService {

    private CommentLikeRepository commentLikeRepository;
    private ModelMapperService modelMapperService;
    private BaseCommentLikeBusinessRules baseCommentLikeBusinessRules;

    @Override
    public void add(AddCommentLikeRequest addCommentLikeRequest) {

        baseCommentLikeBusinessRules.checkCommentIfAlreadyLiked(addCommentLikeRequest.getCommentId(),addCommentLikeRequest.getUserId());

        CommentLike commentLike = modelMapperService.forRequest().map(addCommentLikeRequest,CommentLike.class);

        commentLikeRepository.save(commentLike);

    }

    @Override
    public void delete(int id) {

        commentLikeRepository.deleteById(id);

    }

    @Override
    public boolean isAlreadyLiked(int commentId, int userId) {
        boolean isAlreadyLiked = commentLikeRepository.existsByCommentIdAndUserId(commentId,userId);

        return isAlreadyLiked;
    }

}
