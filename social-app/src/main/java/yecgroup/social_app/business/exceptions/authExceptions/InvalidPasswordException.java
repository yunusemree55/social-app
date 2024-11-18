package yecgroup.social_app.business.exceptions.authExceptions;

import yecgroup.social_app.core.exceptions.BusinessException;

public class InvalidPasswordException extends BusinessException {

	public InvalidPasswordException() {
		super("Invalid Password");
	}

}
