package yecgroup.social_app.core.adapters.javaMailSender.userMail;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yecgroup.social_app.core.adapters.javaMailSender.EmailDetail;
import yecgroup.social_app.core.adapters.javaMailSender.EmailService;

@Service
@AllArgsConstructor
public class UserMailSenderManager implements UserMailSenderService{
	
	private EmailService emailService;
	
	@Override
	public void sendMailAccountCreatedToReceiver(String receiverEmail) {
		
		EmailDetail email = new EmailDetail();
		
		email.setTo(receiverEmail);
		email.setSubject("Success Creating Account");
		email.setText("Your account is created!");
		
		emailService.sendEmail(email);
	}

}
