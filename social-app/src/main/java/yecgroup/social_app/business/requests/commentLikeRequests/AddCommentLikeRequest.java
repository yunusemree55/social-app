package yecgroup.social_app.business.requests.commentLikeRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentLikeRequest {

    private int commentId;
    private int userId;

}
