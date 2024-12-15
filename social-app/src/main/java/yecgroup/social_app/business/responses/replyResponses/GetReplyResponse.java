package yecgroup.social_app.business.responses.replyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReplyResponse {

    private int id;
    private String username;
    private String userProfilePhotoSrc;
    private String content;
}
