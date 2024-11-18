package yecgroup.social_app.business.abstracts;

import yecgroup.social_app.business.requests.authRequests.LoginRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserOnlineStatusRequest;

public interface AuthService {
	
	
	boolean login(LoginRequest loginRequest);
	void logout(UpdateUserOnlineStatusRequest updateUserOnlineStatusRequest);

}
