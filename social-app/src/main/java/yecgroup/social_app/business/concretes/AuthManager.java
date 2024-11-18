package yecgroup.social_app.business.concretes;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.AuthService;
import yecgroup.social_app.business.abstracts.UserService;
import yecgroup.social_app.business.exceptions.authExceptions.InvalidPasswordException;
import yecgroup.social_app.business.requests.authRequests.LoginRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserOnlineStatusRequest;
import yecgroup.social_app.business.responses.userResponses.GetUserForAuth;
import yecgroup.social_app.core.utilities.mapper.modelMapper.ModelMapperService;
import yecgroup.social_app.core.utilities.springSecurityCrypto.PasswordEncoderService;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService{
	
	private UserService userService;
	private ModelMapperService modelMapperService;
	private PasswordEncoderService passwordEncoderService;
	
	@Override
	public boolean login(LoginRequest loginRequest) {
		
		GetUserForAuth userResponse = userService.getUserByEmail(loginRequest.getEmail());
		
		boolean isMatched = passwordEncoderService.matches(loginRequest.getPassword(), userResponse.getPassword());
		
		if(isMatched == false) {
			
			throw new InvalidPasswordException();
		}
		
		UpdateUserOnlineStatusRequest updateUserOnlineStatusRequest = modelMapperService.forRequest().map(userResponse, UpdateUserOnlineStatusRequest.class);
		updateUserOnlineStatusRequest.setOnlineStatusId(1);
		
		userService.updateOnlineStatus(updateUserOnlineStatusRequest);
		
		return isMatched;
		
	}

	@Override
	public void logout(UpdateUserOnlineStatusRequest updateUserOnlineStatusRequest) {
		
		
		userService.updateOnlineStatus(updateUserOnlineStatusRequest);
		
	}

}


