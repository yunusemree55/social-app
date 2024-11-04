package yecgroup.social_app.business.concretes;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.UserService;
import yecgroup.social_app.business.requests.userRequests.AddUserRequest;
import yecgroup.social_app.business.responses.userResponses.GetAllUserResponse;
import yecgroup.social_app.core.exceptions.BusinessException;
import yecgroup.social_app.core.utilities.mapper.modelMapper.ModelMapperService;
import yecgroup.social_app.dataAccess.abstracts.UserRepository;
import yecgroup.social_app.entities.abstracts.BaseUser;
import yecgroup.social_app.entities.concretes.User;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
	
	private UserRepository userRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllUserResponse> getAll() {
		
		List<GetAllUserResponse> userResponseList = userRepository.findAll().stream()
				.map(user -> modelMapperService.forResponse().map(user, GetAllUserResponse.class)).toList();
		
		return userResponseList;
		
	}

	@Override
	public void add(AddUserRequest addUserRequest) {
		
		User user = modelMapperService.forRequest().map(addUserRequest, User.class);
		
		user.setId(0);
		user.setBaseUser(new BaseUser());
		user.getBaseUser().setCreatedAt(new Date());
		
		if(addUserRequest.getPassword().equals(addUserRequest.getConfirmPassword()) == false) {
			throw new BusinessException("Şifreler uyuşmuyor");
		}	
		
		userRepository.save(user);
	} 

}
