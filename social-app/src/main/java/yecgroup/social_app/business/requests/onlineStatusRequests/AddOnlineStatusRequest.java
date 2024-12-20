package yecgroup.social_app.business.requests.onlineStatusRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yecgroup.social_app.core.utilities.ValidationConstant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOnlineStatusRequest {

	@NotBlank(message = ValidationConstant.notBlank)
	private String name;

}
