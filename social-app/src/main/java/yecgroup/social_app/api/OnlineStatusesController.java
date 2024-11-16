package yecgroup.social_app.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.OnlineStatusService;
import yecgroup.social_app.business.requests.onlineStatusRequests.AddOnlineStatusRequest;
import yecgroup.social_app.business.responses.onlineStatusResponses.GetAllOnlineStatusResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/api/online-statuses")
public class OnlineStatusesController {
	
	private OnlineStatusService onlineStatusService;
	
	@GetMapping("/all")
	public List<GetAllOnlineStatusResponse> getAll(){
		
		return onlineStatusService.getAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid AddOnlineStatusRequest addOnlineStatusRequest) {
		
		onlineStatusService.add(addOnlineStatusRequest);
	}

}
