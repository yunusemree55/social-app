package yecgroup.social_app.business.requests.statusRequests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.utilities.ValidationConstant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStatusRequest {

	@NotBlank(message = ValidationConstant.notBlank)
	private String name;

}
