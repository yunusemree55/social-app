package yecgroup.social_app.business.exceptions.authExceptions;

import yecgroup.social_app.core.exceptions.BusinessException;

public class UserNotFoundException extends BusinessException{

	public UserNotFoundException() {
		super("User not found");
	}

}
