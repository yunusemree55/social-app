package yecgroup.social_app.core.utilities.springSecurityCrypto;

public interface PasswordEncoderService {
	
	String encode(String rawPassword);
	boolean matches(String rawPassword,String encodedPassword);
}
