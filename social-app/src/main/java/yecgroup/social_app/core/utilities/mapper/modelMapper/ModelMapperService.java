package yecgroup.social_app.core.utilities.mapper.modelMapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	
	ModelMapper forResponse();
	ModelMapper forRequest();

}
