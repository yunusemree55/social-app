package yecgroup.social_app.business.rules.userBusinessRules;

public interface BaseUserBusinessRules {
	
	void checkPasswordFields(String password,String confirmPassword);
	void checkEmailExistBefore(String email);
	void checkUsernameExistBefore(String username);

}
