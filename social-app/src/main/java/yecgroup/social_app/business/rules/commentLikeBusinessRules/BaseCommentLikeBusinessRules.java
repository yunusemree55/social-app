package yecgroup.social_app.business.rules.commentLikeBusinessRules;

public interface BaseCommentLikeBusinessRules {

    void checkCommentIfAlreadyLiked(int commentId,int userId);

}
