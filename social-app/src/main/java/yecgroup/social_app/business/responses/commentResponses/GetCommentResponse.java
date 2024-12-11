package yecgroup.social_app.business.responses.commentResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCommentResponse {

    private int id;
    private int userId;
    private String username;
    private String userSrc;
    private String content;
}
