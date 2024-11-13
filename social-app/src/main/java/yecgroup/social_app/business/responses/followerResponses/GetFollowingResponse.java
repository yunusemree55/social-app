package yecgroup.social_app.business.responses.followerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetFollowingResponse {
	
	private int id;
	private int followingUserId;
	private String followingUserUsername;
	private String followingUserProfilePhotoSrc;

}
