package yecgroup.social_app.business.responses.followerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetFollowerResponse {
	
	private int id;
	private int followerUserId;
	private String followerUserUsername;
	private String followerUserProfilePhotoSrc;

}
