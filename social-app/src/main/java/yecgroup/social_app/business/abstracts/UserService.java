package yecgroup.social_app.business.abstracts;

import java.util.List;

import yecgroup.social_app.business.requests.userRequests.AddUserRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserEmailRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserOnlineStatusRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserPasswordRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserUsernameRequest;
import yecgroup.social_app.business.responses.userResponses.GetAllUserResponse;
import yecgroup.social_app.business.responses.userResponses.GetUserForAuth;
import yecgroup.social_app.business.responses.userResponses.GetUserResponse;

public interface UserService{
	
	List<GetAllUserResponse> getAll();
	GetUserResponse getUserById(int id);
	GetUserForAuth getUserByEmail(String email);
	
	void add(AddUserRequest addUserRequest);
	void updateEmail(UpdateUserEmailRequest updateUserRequest);
	void updateUsername(UpdateUserUsernameRequest updateUserUsernameRequest);
	void updatePassword(UpdateUserPasswordRequest updateUserPasswordRequest);
	void updateOnlineStatus(UpdateUserOnlineStatusRequest updateUserOnlineStatusRequest);
}
