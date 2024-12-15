package yecgroup.social_app.business.abstracts;

import yecgroup.social_app.business.requests.replyRequests.AddReplyRequest;
import yecgroup.social_app.business.responses.replyResponses.GetReplyResponse;

public interface ReplyService {

    GetReplyResponse getById(int id);

    void add(AddReplyRequest addReplyRequest);
    void delete(int id);
}
