package yecgroup.social_app.core.adapters.imageKit;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageKitService {
	
	String upload(MultipartFile file) throws IOException;

}
