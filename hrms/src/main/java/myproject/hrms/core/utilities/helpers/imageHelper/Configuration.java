package myproject.hrms.core.utilities.helpers.imageHelper;

import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@org.springframework.context.annotation.Configuration
public class Configuration {
	@Bean
	public ImageService imageService() {
		return new CloudinaryManager(cloudinary());
	}

	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "dpe76dh3u",
				"api_key", "169558899666731", "api_secret","Q2H3YmpArnFL3tdInYQRt-HKeX0"));
	}
}
