package yecgroup.social_app.business.concretes;

import java.io.IOException;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.ProfilePhotoService;
import yecgroup.social_app.business.requests.profilePhotoRequests.AddProfilePhotoRequest;
import yecgroup.social_app.core.adapters.imageKit.ImageKitService;
import yecgroup.social_app.core.utilities.mapper.modelMapper.ModelMapperService;
import yecgroup.social_app.dataAccess.abstracts.ProfilePhotoRepository;
import yecgroup.social_app.entities.abstracts.Photo;
import yecgroup.social_app.entities.concretes.ProfilePhoto;


@Service
@AllArgsConstructor
public class ProfilePhotoManager implements ProfilePhotoService {
	
	private ProfilePhotoRepository profilePhotoRepository;
	private ImageKitService imageKitService;
	private ModelMapperService modelMapperService;

	@Override
	public void add(AddProfilePhotoRequest addProfilePhotoRequest) throws IOException{
		
		String src = imageKitService.upload(addProfilePhotoRequest.getFile());
		
		if(src != null) {
			ProfilePhoto profilePhoto = new ProfilePhoto();
			profilePhoto = modelMapperService.forRequest().map(addProfilePhotoRequest, ProfilePhoto.class);
			
			profilePhoto.setId(0);
			profilePhoto.setPhoto(new Photo());
			profilePhoto.getPhoto().setSrc(src); 
			
			profilePhotoRepository.save(profilePhoto);
		}
		

	}

}
