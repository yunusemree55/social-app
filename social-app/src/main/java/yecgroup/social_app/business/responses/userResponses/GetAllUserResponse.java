package yecgroup.social_app.business.responses.userResponses;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponse {
	
	private int id;
	private String email;
	private String username;
	private String statusName;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date createdAt;

}
