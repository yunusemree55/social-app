package yecgroup.social_app.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.UserService;
import yecgroup.social_app.business.requests.userRequests.AddUserRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserEmailRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserPasswordRequest;
import yecgroup.social_app.business.requests.userRequests.UpdateUserUsernameRequest;
import yecgroup.social_app.business.responses.userResponses.GetAllUserResponse;
import yecgroup.social_app.business.responses.userResponses.GetUserResponse;
import yecgroup.social_app.business.rules.userBusinessRules.BaseUserBusinessRules;
import yecgroup.social_app.core.adapters.javaMailSender.userMail.UserMailSenderService;
import yecgroup.social_app.core.utilities.mapper.modelMapper.ModelMapperService;
import yecgroup.social_app.core.utilities.springSecurityCrypto.PasswordEncoderService;
import yecgroup.social_app.dataAccess.abstracts.UserRepository;
import yecgroup.social_app.entities.concretes.OnlineStatus;
import yecgroup.social_app.entities.concretes.Status;
import yecgroup.social_app.entities.concretes.User;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
	
	private UserRepository userRepository;
	private ModelMapperService modelMapperService;
	private BaseUserBusinessRules baseUserBusinessRules;
	private UserMailSenderService userMailSenderService;
	private PasswordEncoderService passwordEncoderService;


	@Override
	public List<GetAllUserResponse> getAll() {
		
		List<GetAllUserResponse> userResponseList = userRepository.findAll().stream()
				.map(user -> modelMapperService.forResponse().map(user, GetAllUserResponse.class)).toList();
		
		return userResponseList;
		
	}
	
	@Override
	public GetUserResponse getUserById(int id) {
		
		User target = userRepository.findById(id).orElseThrow();
		
		GetUserResponse userResponse = modelMapperService.forResponse().map(target, GetUserResponse.class);
		userResponse.setId(target.getId());

		return userResponse; 
	}

	@Override
	public void add(AddUserRequest addUserRequest) {
		
		baseUserBusinessRules.checkEmailExistBefore(addUserRequest.getEmail());
		baseUserBusinessRules.checkUsernameExistBefore(addUserRequest.getUsername());
		baseUserBusinessRules.checkPasswordFields(addUserRequest.getPassword(), addUserRequest.getConfirmPassword());
		
		User user = modelMapperService.forRequest().map(addUserRequest, User.class);
		
		
		user.setStatus(new Status());
		user.setOnlineStatus(new OnlineStatus());
		user.getStatus().setId(1); 
		user.getOnlineStatus().setId(2);
		user.setPassword(passwordEncoderService.encode(user.getPassword()));
		
		userRepository.save(user);
		userMailSenderService.sendMailAccountCreatedToReceiver(user.getEmail());
	}

	@Override
	public void updateEmail(UpdateUserEmailRequest updateUserEmailRequest) {
		
		userRepository.findById(updateUserEmailRequest.getId()).orElseThrow();
		
		baseUserBusinessRules.checkEmailExistBefore(updateUserEmailRequest.getEmail());
		
		userRepository.updateEmail(updateUserEmailRequest.getId(),updateUserEmailRequest.getEmail());
		
		
	}

	@Override
	public void updateUsername(UpdateUserUsernameRequest updateUserUsernameRequest) {
		
		userRepository.findById(updateUserUsernameRequest.getId()).orElseThrow();
		
		baseUserBusinessRules.checkUsernameExistBefore(updateUserUsernameRequest.getUsername());

		
		userRepository.updateUsername(updateUserUsernameRequest.getId(), updateUserUsernameRequest.getUsername());
	
	}

	@Override
	public void updatePassword(UpdateUserPasswordRequest updateUserPasswordRequest) {
		
		baseUserBusinessRules.checkPasswordFields(updateUserPasswordRequest.getPassword(), updateUserPasswordRequest.getConfirmPassword());
		
		String encodedPassword = passwordEncoderService.encode(updateUserPasswordRequest.getPassword());
		
		userRepository.updatePassword(updateUserPasswordRequest.getId(), encodedPassword);
		
	}

}
