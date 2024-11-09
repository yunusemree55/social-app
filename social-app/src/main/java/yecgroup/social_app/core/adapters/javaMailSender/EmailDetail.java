package yecgroup.social_app.core.adapters.javaMailSender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetail {
	
	private String to;
	private String subject;
	private String text;

}
