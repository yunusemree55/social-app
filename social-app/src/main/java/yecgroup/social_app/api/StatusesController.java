package yecgroup.social_app.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.StatusService;
import yecgroup.social_app.business.requests.statusRequests.AddStatusRequest;


@RestController
@AllArgsConstructor
@RequestMapping("/api/statuses")
public class StatusesController {
	
	private StatusService statusService;
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid AddStatusRequest addStatusRequest) {
		
		statusService.add(addStatusRequest);
		
	}

}
