package yecgroup.social_app.business.requests.statusRequests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStatusRequest {
	
	@NotBlank()
	private String name;

}
