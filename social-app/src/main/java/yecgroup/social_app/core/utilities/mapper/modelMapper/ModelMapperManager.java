package yecgroup.social_app.core.utilities.mapper.modelMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelMapperManager implements ModelMapperService{
	
	private ModelMapper modelMapper;

	@Override
	public ModelMapper forResponse() {
		
		this.modelMapper.getConfiguration().
		setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		return modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		
		this.modelMapper.getConfiguration().
		setAmbiguityIgnored(false)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		
		return modelMapper;
	}

}
