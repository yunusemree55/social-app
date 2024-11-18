package yecgroup.social_app.business.requests.userRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserOnlineStatusRequest {
	
	private int id;
	private int onlineStatusId;

}
