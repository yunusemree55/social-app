package yecgroup.social_app.business.responses.likeResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLikeResponse {
	
	private int id;
	private int userId;
	private String username;
	private String userSrc;

}
