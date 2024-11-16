package yecgroup.social_app.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.OnlineStatusService;
import yecgroup.social_app.business.requests.onlineStatusRequests.AddOnlineStatusRequest;
import yecgroup.social_app.business.responses.onlineStatusResponses.GetAllOnlineStatusResponse;
import yecgroup.social_app.core.utilities.mapper.modelMapper.ModelMapperService;
import yecgroup.social_app.dataAccess.abstracts.OnlineStatusRepository;
import yecgroup.social_app.entities.concretes.OnlineStatus;

@Service
@AllArgsConstructor
public class OnlineStatusManager implements OnlineStatusService {
	
	private OnlineStatusRepository onlineStatusRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllOnlineStatusResponse> getAll() {
		
		List<GetAllOnlineStatusResponse> onlineStatusResponseList = onlineStatusRepository.findAll().stream()
				.map(onlineStatus -> modelMapperService.forResponse().map(onlineStatus, GetAllOnlineStatusResponse.class)).collect(Collectors.toList());
	
		return onlineStatusResponseList;
	}

	@Override
	public void add(AddOnlineStatusRequest addOnlineStatusRequest) {

		OnlineStatus onlineStatus = modelMapperService.forRequest().map(addOnlineStatusRequest, OnlineStatus.class);
		
		onlineStatus.setId(0);
		
		onlineStatusRepository.save(onlineStatus);

	}

}
