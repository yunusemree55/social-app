package yecgroup.social_app.business.rules.userBusinessRules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yecgroup.social_app.core.exceptions.BusinessException;
import yecgroup.social_app.dataAccess.abstracts.UserRepository;

@Service
@AllArgsConstructor
public class UserBusinessRules {
	
	private UserRepository userRepository;
	
	public void checkPasswordFields(String password,String confirmPassword) {
		
		if(password.contentEquals(confirmPassword) == false) {
			
			throw new BusinessException("Passwords are not matched");
		}
		
	}
	
	public void checkEmailExistBefore(String email) {
		
		boolean isExistedBefore = userRepository.existsUserByEmail(email);
		
		if(isExistedBefore) {
			
			throw new BusinessException("This email is existed before");
		}
		
		
	}
	
	
	

}
