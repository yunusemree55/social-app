package yecgroup.social_app.business.abstracts;

import java.util.List;

import yecgroup.social_app.business.requests.userRequests.AddUserRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserEmailRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserUsernameRequest;
import yecgroup.social_app.business.responses.userResponses.GetAllUserResponse;

public interface UserService{
	
	List<GetAllUserResponse> getAll();
	void add(AddUserRequest addUserRequest);
	void updateEmail(UpdateUserEmailRequest updateUserRequest);
	void updateUsername(UpdateUserUsernameRequest updateUserUsernameRequest);
	
	
}
