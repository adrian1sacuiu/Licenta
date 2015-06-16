package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;


public class OperationsUtils {
	private static final Logger logger = Logger.getLogger(OperationsUtils.class);
	
	public static void validateImage(MultipartFile image) {
		logger.info("Inside validateImage method.");
		
		if (!image.getContentType().equals("image/jpeg")) {
			throw new ImageUploadException("Only JPG images accepted.");
		}
	}

	public static void saveImage(String username, MultipartFile image) throws ImageUploadException {
		logger.info("Inside saveImage method.");
		
		try {
			File file = new File("src/main/webapp/resources/images/" + username);
			file.mkdirs();
			file = new File(file, "/" + username + ".jpg");
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			
		} catch (IOException e) {
			logger.error("in saveImage method IOException: " + e.getMessage() + ";Cause: " + e.getCause());
			throw new ImageUploadException("Unable to save image.", e);
		}
	}
}
