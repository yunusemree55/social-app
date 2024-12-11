package yecgroup.social_app.business.requests.commentRequests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.utilities.ValidationConstant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentRequest {

    private int postId;
    private int userId;

    @NotBlank(message = ValidationConstant.notBlank)
    private String content;
}
