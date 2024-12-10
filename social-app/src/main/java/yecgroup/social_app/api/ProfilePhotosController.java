package yecgroup.social_app.api;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.ProfilePhotoService;
import yecgroup.social_app.business.requests.profilePhotoRequests.AddProfilePhotoRequest;
import yecgroup.social_app.business.requests.profilePhotoRequests.UpdateProfilePhotoRequest;

@RestController
@AllArgsConstructor
@RequestMapping("/api/profilePhotos")
public class ProfilePhotosController {
	
	private ProfilePhotoService profilePhotoService;

	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@ModelAttribute AddProfilePhotoRequest addProfilePhotoRequest) throws IOException {
		
		profilePhotoService.add(addProfilePhotoRequest);
	}
	
	@PostMapping("/update")
	public void update(@ModelAttribute UpdateProfilePhotoRequest updateProfilePhotoRequest) throws IOException{
		
		profilePhotoService.update(updateProfilePhotoRequest);
	}
}
