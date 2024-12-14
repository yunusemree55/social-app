package yecgroup.social_app.business.rules.commentLikeBusinessRules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import yecgroup.social_app.business.abstracts.CommentLikeService;
import yecgroup.social_app.core.exceptions.BusinessException;
import yecgroup.social_app.core.utilities.ExceptionMessageConstant;

@Service
public class CommentLikeBusinessRules implements  BaseCommentLikeBusinessRules{

    @Lazy
    @Autowired
    private CommentLikeService commentLikeService;


    @Override
    public void checkCommentIfAlreadyLiked(int commentId,int userId) {

        boolean result = commentLikeService.isAlreadyLiked(commentId,userId);

        if(result){
            throw new BusinessException(ExceptionMessageConstant.commentLikeErrorMessage);
        }

    }
}
