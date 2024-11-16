package yecgroup.social_app.business.responses.userResponses;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.business.responses.followerResponses.GetFollowerResponse;
import yecgroup.social_app.business.responses.followerResponses.GetFollowingResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {
	
	private int id;
	private String email;
	private String username;
	private String statusName;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private LocalDateTime createdAt;
	private String profilePhotoSrc;
	private String onlineStatusName;
	private List<GetFollowerResponse> followers;
	private List<GetFollowingResponse> followings;
	

}
