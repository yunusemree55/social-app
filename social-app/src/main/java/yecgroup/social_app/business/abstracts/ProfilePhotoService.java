package yecgroup.social_app.business.abstracts;

import java.io.IOException;

import yecgroup.social_app.business.requests.profilePhotoRequests.AddProfilePhotoRequest;
import yecgroup.social_app.business.requests.profilePhotoRequests.UpdateProfilePhotoRequest;

public interface ProfilePhotoService {
	
	void add(AddProfilePhotoRequest addProfilePhotoRequest) throws IOException;
	void update(UpdateProfilePhotoRequest updateProfilePhotoRequest) throws IOException;

}
