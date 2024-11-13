package yecgroup.social_app.business.requests.followerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFollowerRequest {
	
	private int followerUserId;
	private int followingUserId;

}
