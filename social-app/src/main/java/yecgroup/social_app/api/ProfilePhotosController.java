package yecgroup.social_app.api;

import java.io.IOException;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import yecgroup.social_app.business.abstracts.ProfilePhotoService;
import yecgroup.social_app.business.requests.profilePhotoRequests.AddProfilePhotoRequest;

@RestController
@AllArgsConstructor
@RequestMapping("/api/profilePhotos")
public class ProfilePhotosController {
	
	private ProfilePhotoService profilePhotoService;

	@PostMapping("/add")
	public void add(@ModelAttribute AddProfilePhotoRequest addProfilePhotoRequest) throws IOException {
		
		profilePhotoService.add(addProfilePhotoRequest);
	}
}
