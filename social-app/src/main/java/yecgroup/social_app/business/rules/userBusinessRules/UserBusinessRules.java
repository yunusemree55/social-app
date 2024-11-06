package yecgroup.social_app.business.rules.userBusinessRules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yecgroup.social_app.core.exceptions.BusinessException;
import yecgroup.social_app.core.utilities.BusinessRuleConstant;
import yecgroup.social_app.dataAccess.abstracts.UserRepository;

@Service
@AllArgsConstructor
public class UserBusinessRules implements BaseUserBusinessRules{
	
	private UserRepository userRepository;
	
	@Override
	public void checkPasswordFields(String password,String confirmPassword) {
		
		if(password.contentEquals(confirmPassword) == false) {
			
			throw new BusinessException(BusinessRuleConstant.passwordsNotMatched);
		}
		
	}
	
	@Override
	public void checkEmailExistBefore(String email) {
		
		boolean isExistedBefore = userRepository.existsUserByEmail(email);
		
		if(isExistedBefore == true) {
			
			throw new BusinessException(BusinessRuleConstant.emailAlreadyExists);
		}
		
		
	}

	@Override
	public void checkUsernameExistBefore(String username) {
		
		boolean isExistedBefore = userRepository.existsUserByUsername(username);
		
		if(isExistedBefore == true) {
			throw new BusinessException(BusinessRuleConstant.usernameAlreadyExists);
		}
	}
	
	
	

}
