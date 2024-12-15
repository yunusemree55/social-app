package yecgroup.social_app.business.responses.commentResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.business.responses.commentLikeResponses.GetCommentLikeResponse;
import yecgroup.social_app.business.responses.replyResponses.GetReplyResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCommentResponse {

    private int id;
    private int userId;
    private String username;
    private String userSrc;
    private String content;
    private List<GetCommentLikeResponse> commentLikes;
    private List<GetReplyResponse> replies;
}
