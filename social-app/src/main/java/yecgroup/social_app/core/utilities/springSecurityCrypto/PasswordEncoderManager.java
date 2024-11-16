package yecgroup.social_app.core.utilities.springSecurityCrypto;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PasswordEncoderManager implements PasswordEncoderService{
	
	private PasswordEncoder passwordEncoder;

	@Override
	public String encode(String rawPassword) {
		
		return passwordEncoder.encode(rawPassword);
		
	}

	@Override
	public boolean matches(String rawPassword, String encodedPassword) {

		return passwordEncoder.matches(rawPassword, encodedPassword);
		
	}
	
	

}
