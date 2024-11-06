package yecgroup.social_app.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.UserService;
import yecgroup.social_app.business.requests.userRequests.AddUserRequest;
import yecgroup.social_app.business.responses.userResponses.GetAllUserResponse;
import yecgroup.social_app.business.rules.userBusinessRules.BaseUserBusinessRules;
import yecgroup.social_app.core.utilities.mapper.modelMapper.ModelMapperService;
import yecgroup.social_app.dataAccess.abstracts.UserRepository;
import yecgroup.social_app.entities.concretes.Status;
import yecgroup.social_app.entities.concretes.User;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
	
	private UserRepository userRepository;
	private ModelMapperService modelMapperService;
	private BaseUserBusinessRules baseUserBusinessRules;

	@Override
	public List<GetAllUserResponse> getAll() {
		
		List<GetAllUserResponse> userResponseList = userRepository.findAll().stream()
				.map(user -> modelMapperService.forResponse().map(user, GetAllUserResponse.class)).toList();
		
		return userResponseList;
		
	}

	@Override
	public void add(AddUserRequest addUserRequest) {
		
		baseUserBusinessRules.checkEmailExistBefore(addUserRequest.getEmail());
		baseUserBusinessRules.checkUsernameExistBefore(addUserRequest.getUsername());
		baseUserBusinessRules.checkPasswordFields(addUserRequest.getPassword(), addUserRequest.getConfirmPassword());
		
		User user = modelMapperService.forRequest().map(addUserRequest, User.class);
		
		user.setStatus(new Status());
		user.getStatus().setId(1); 
		
		
		userRepository.save(user);
	} 

}
