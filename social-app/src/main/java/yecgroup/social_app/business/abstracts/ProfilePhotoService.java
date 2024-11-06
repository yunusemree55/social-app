package yecgroup.social_app.business.abstracts;

import java.io.IOException;

import yecgroup.social_app.business.requests.profilePhotoRequests.AddProfilePhotoRequest;

public interface ProfilePhotoService {
	
	void add(AddProfilePhotoRequest addProfilePhotoRequest) throws IOException;

}
