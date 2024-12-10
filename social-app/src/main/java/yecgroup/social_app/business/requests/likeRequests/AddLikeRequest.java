package yecgroup.social_app.business.requests.likeRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLikeRequest {
	
	private int postId;
	private int userId;
	

}
