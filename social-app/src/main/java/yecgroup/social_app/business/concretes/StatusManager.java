package yecgroup.social_app.business.concretes;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.StatusService;
import yecgroup.social_app.business.requests.statusRequests.AddStatusRequest;
import yecgroup.social_app.core.utilities.mapper.modelMapper.ModelMapperService;
import yecgroup.social_app.dataAccess.abstracts.StatusRepository;
import yecgroup.social_app.entities.concretes.Status;

@Service
@AllArgsConstructor
public class StatusManager implements StatusService {
	
	private StatusRepository statusRepository;
	private ModelMapperService modelMapperService;

	@Override
	public void add(AddStatusRequest addStatusRequest) {
		
		Status status = modelMapperService.forRequest().map(addStatusRequest, Status.class);
		status.setId(0);
		
		statusRepository.save(status);

	}

}
