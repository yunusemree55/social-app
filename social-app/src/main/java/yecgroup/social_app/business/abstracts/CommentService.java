package yecgroup.social_app.business.abstracts;

import yecgroup.social_app.business.requests.commentRequests.AddCommentRequest;
import yecgroup.social_app.business.responses.commentResponses.GetCommentResponse;

public interface CommentService {

    GetCommentResponse getById(int id);

    void add(AddCommentRequest addCommentRequest);
    void delete(int id);

}
