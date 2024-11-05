package yecgroup.social_app.business.abstracts;

import yecgroup.social_app.business.requests.statusRequests.AddStatusRequest;

public interface StatusService {
	
	void add(AddStatusRequest addStatusRequest);

}
