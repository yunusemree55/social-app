package yecgroup.social_app.core.adapters.javaMailSender;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailManager implements EmailService{
	
	private JavaMailSender javaMailSender;
	private SimpleMailMessage simpleMailMessage;
	
	@Override
	public void sendEmail(EmailDetail emailDetail) {	
		
		simpleMailMessage.setTo(emailDetail.getTo());
		simpleMailMessage.setSubject(emailDetail.getSubject());
		simpleMailMessage.setText(emailDetail.getText());
		
		javaMailSender.send(simpleMailMessage);
		
		
	}

}
