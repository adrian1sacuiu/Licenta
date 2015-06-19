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
			File userFolder = new File(Constants.ImagesFolder + username);
			userFolder.mkdirs();
			userFolder = new File(userFolder, "/" + username + ".jpg");
			FileUtils.writeByteArrayToFile(userFolder, image.getBytes());
			
		} catch (IOException e) {
			logger.error("in saveImage method IOException: " + e.getMessage() + ";Cause: " + e.getCause());
			throw new ImageUploadException("Unable to save image.", e);
		}
	}
	
	public static boolean deleteDir(File dir) {
		logger.info("Inside deleteDir method.");
		boolean result = false;
		
	    try {
			if (dir.exists() && dir.isDirectory()) {
			    String[] children = dir.list();
			    for (int i = 0; i < children.length; i++) {
			        boolean success = deleteDir(new File(dir, children[i]));
			        if (!success) {
			            return false;
			        }
			    }
			}
			
			result = dir.delete();
			
		} catch (Exception e) {
			logger.error("in deleteDir method Exception: " + e.getMessage() + ";Cause: " + e.getCause());
			e.printStackTrace();
		} 
	    
	    return result; 
	}
}
