package yecgroup.social_app.business.abstracts;

import yecgroup.social_app.business.requests.commentLikeRequests.AddCommentLikeRequest;

public interface CommentLikeService {

    void add(AddCommentLikeRequest addCommentLikeRequest);
    void delete(int id);

    boolean isAlreadyLiked(int commentId,int userId);
}
