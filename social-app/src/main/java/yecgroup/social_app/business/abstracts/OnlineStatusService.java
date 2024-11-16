package yecgroup.social_app.business.abstracts;

import java.util.List;

import yecgroup.social_app.business.requests.onlineStatusRequests.AddOnlineStatusRequest;
import yecgroup.social_app.business.responses.onlineStatusResponses.GetAllOnlineStatusResponse;

public interface OnlineStatusService {
	
	List<GetAllOnlineStatusResponse> getAll();
	void add(AddOnlineStatusRequest addOnlineStatusRequest);

}
