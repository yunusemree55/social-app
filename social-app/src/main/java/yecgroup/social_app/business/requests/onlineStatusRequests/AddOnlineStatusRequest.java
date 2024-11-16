package yecgroup.social_app.business.requests.onlineStatusRequests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOnlineStatusRequest {
	
	@NotNull
	private String name;

}
